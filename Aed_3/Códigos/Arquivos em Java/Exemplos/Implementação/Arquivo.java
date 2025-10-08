import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Registro> {
    final int TAM_CABECALHO = 12;
    RandomAccessFile arquivo;
    String nomeArquivo;
    Constructor<T> construtor;
    HashExtensivel<ParIDEndereco> indiceDireto;

    public Arquivo(String na, Constructor<T> c) throws Exception {
        File d = new File(".\\dados");
        if(!d.exists())
            d.mkdir();

        d = new File(".\\dados\\"+na);
        if(!d.exists())
            d.mkdir();

        this.nomeArquivo = ".\\dados\\"+na+"\\"+na+".db";
        this.construtor = c;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        if(arquivo.length()<TAM_CABECALHO) {
            // inicializa o arquivo, criando seu cabecalho
            arquivo.writeInt(0);   // último ID
            arquivo.writeLong(-1);   // lista de registros marcados para exclusão 
        }

        indiceDireto = new HashExtensivel<>(
            ParIDEndereco.class.getConstructor(), 
            4, 
            ".\\dados\\"+na+"\\"+na+".d.db", // diretório 
            ".\\dados\\"+na+"\\"+na+".c.db"  // cestos
        );
    }

    public Arquivo() {
    }

    /**
     * Criação de objetos em arquivo de acesso aleatório
     * @param obj Objeto a ser inserido
     * @return Id do objeto
     * @throws Exception Tratamento de excessões
     */
    public int create(T obj) throws Exception {

        arquivo.seek(0); // Acessa primeira posição
        int ultimoId = arquivo.readInt(); // Lê ultimo id
        obj.setId(ultimoId + 1); // Seta id do objeto
        arquivo.seek(0); // Volta para início
        arquivo.writeInt(obj.getId()); // Registra o dado

        long endereco = arquivo.length(); // Obtém endereço de escrita do novo dado
        byte[] b = obj.toByteArray(); // Converte objeto para vetor de bytes
        arquivo.seek(endereco); // Acessa endereço
        arquivo.write(b); // Escreve dados

        indiceDireto.create(new ParIDEndereco(obj.getId(), endereco)); // Adiciona novo par

        return obj.getId();
    }
    
    public T read(int id) throws Exception {
        
        T obj;
        short tam;
        byte lapide;
        byte[] b;
        ParIDEndereco pid = indiceDireto.read(id); // Localiza registro
        
        if(pid != null){

            arquivo.seek(pid.getEndereco()); // Acessa registro
            obj = construtor.newInstance(); // Instancia objeto genérico
            lapide = arquivo.readByte(); // Verifica a lápide

            if(lapide == ' '){ // Caso a lápide esteja viva

                tam = arquivo.readShort(); // Leia tamanho do registro
                b = new byte[tam]; // Cria vetor de bytes para registro
                arquivo.read(b); // Lê os dados e armazena no vetor
                obj.fromByteArray(b); // Seta os dados no objeto
                if( obj.getId() == id) // Caso os ids correspondam retornam
             
                    return obj;
            }
        }

        return null;
    }

    public boolean delete(int id) throws Exception {
        T obj;
        short tam;
        byte[] b;
        byte lapide;

        ParIDEndereco pie = indiceDireto.read(id); // Localiza objeto
        if(pie!=null) {
            arquivo.seek(pie.getEndereco()); // Acessa objeto
            obj = construtor.newInstance(); // Instancia objeto
            lapide = arquivo.readByte(); // Verifica lápide
            if(lapide==' ') {
                tam = arquivo.readShort(); // Obtem tamanho de registro
                b = new byte[tam]; // Vetor de bytes
                arquivo.read(b); // Lê dados
                obj.fromByteArray(b); // Converte bytes para objetos
                if(obj.getId()==id) { 
                    if(indiceDireto.delete(id)) { // Deleta indice indireto
                        arquivo.seek(pie.getEndereco()); // Acessa endereco
                        arquivo.write('*'); // Seta lápide como morta
                        addDeleted(tam, pie.getEndereco()); // Adiciona aos deletados
                        return true; // True
                    }
                }
            }
        }
        return false;
    }

    public boolean update(T novoObj) throws Exception {
        T obj;
        short tam;
        byte[] b;
        byte lapide;
        ParIDEndereco pie = indiceDireto.read(novoObj.getId()); // Obtém endereço do objeto
        if(pie!=null) {
            arquivo.seek(pie.getEndereco()); // Acessa objeto
            obj = construtor.newInstance(); // Instancia construtor
            lapide = arquivo.readByte(); // Lê lápide
            if(lapide==' ') { 
                tam = arquivo.readShort(); // Lê tamanho do registro
                b = new byte[tam]; // Aloca vetor de Bytes
                arquivo.read(b); // Lê dados
                obj.fromByteArray(b); // Converte bytes para objeto
                if(obj.getId()==novoObj.getId()) {

                    byte[] b2 = novoObj.toByteArray(); // Converte novo dado para vetor
                    short tam2 = (short)b2.length;  // Obtem tamanho do novo registro

                    // sobrescreve o registro
                    if(tam2 <= tam) {
                        arquivo.seek(pie.getEndereco()+3); // Lápide + tamanho + id
                        arquivo.write(b2);
                    }

                    // move o novo registro para o fim
                    else {
                        // exclui o registro anterior
                        arquivo.seek(pie.getEndereco());
                        arquivo.write('*');
                        addDeleted(tam, pie.getEndereco());                        

                        // grava o novo registro
                        long novoEndereco = getDeleted(b.length);   // tenta reusar algum espaço de registro excluído
                        if(novoEndereco == -1) {   // nenhum espaço disponível; escreve o registro no fim do arquivo  
                            arquivo.seek(arquivo.length());
                            novoEndereco = arquivo.getFilePointer();
                            arquivo.writeByte(' ');       // lápide
                            arquivo.writeShort(tam2);       // tamanho do vetor de bytes
                            arquivo.write(b2);              // vetor de bytes
                        } else {
                            arquivo.seek(novoEndereco);
                            arquivo.writeByte(' ');       // limpa o lápide
                            arquivo.skipBytes(2);         // pula o indicador de tamanho para preservá-lo
                            arquivo.write(b2);              // vetor de bytes
                        }

                        // atualiza o índice direto
                        indiceDireto.update(new ParIDEndereco(novoObj.getId(), novoEndereco));
                    }
                    return true;
                }
            }
        }
        return false;
    }

    // adiciona um registro à lista de excluídos (espaços disponíveis para reuso)
    public void addDeleted(int tamanhoEspaco, long enderecoEspaco) throws Exception {
        long anterior = 4; // início da lista
        arquivo.seek(anterior);
        long endereco = arquivo.readLong(); // endereço do elemento que será testado
        long proximo; // endereço do elemento seguinte da lista
        int tamanho;
        if(endereco==-1) {  // lista vazia
            arquivo.seek(4);
            arquivo.writeLong(enderecoEspaco);
            arquivo.seek(enderecoEspaco+3);
            arquivo.writeLong(-1);
        } else {
            do {
                arquivo.seek(endereco+1);
                tamanho = arquivo.readShort();
                proximo = arquivo.readLong();
                if(tamanho > tamanhoEspaco) {  // encontrou a posição de inserção (antes do elemento atual)
                    if(anterior == 4) // será o primeiro elemento da lista
                        arquivo.seek(anterior);
                    else
                        arquivo.seek(anterior+3);
                    arquivo.writeLong(enderecoEspaco);
                    arquivo.seek(enderecoEspaco+3);
                    arquivo.writeLong(endereco);
                    break;
                }
                if(proximo == -1) {  // fim da lista
                    arquivo.seek(endereco+3);
                    arquivo.writeLong(enderecoEspaco);
                    arquivo.seek(enderecoEspaco+3);
                    arquivo.writeLong(+1);
                    break;
                }
                anterior = endereco;
                endereco = proximo;
            } while (endereco!=-1);
        }
    }
    
    // retira um registro à lista de excluídos para reuso, mas com o risco de algum desperdício
    // se necessário, o código pode ser alterado para controlar um limite máximo de desperdício
    public long getDeleted(int tamanhoNecessario) throws Exception {
        long anterior = 4; // início da lista
        arquivo.seek(anterior);
        long endereco = arquivo.readLong(); // endereço do elemento que será testado
        long proximo; // endereço do elemento seguinte da lista
        int tamanho;
        while(endereco != -1) {
            arquivo.seek(endereco+1);
            tamanho = arquivo.readShort();
            proximo = arquivo.readLong();
            if(tamanho > tamanhoNecessario) {  
                if(anterior == 4)  // o elemento é o primeiro da lista 
                    arquivo.seek(anterior);
                else
                    arquivo.seek(anterior+3);
                arquivo.writeLong(proximo);
                break;
            }
            anterior = endereco;
            endereco = proximo;
        }
        return endereco;
    }

    public void close() throws Exception {
        arquivo.close();
        indiceDireto.close();
    }
}