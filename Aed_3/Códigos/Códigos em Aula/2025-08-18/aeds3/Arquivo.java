package aeds3;
import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Classe de arquivos para dados genericos
 * 
 * -> O tipo genérico T é extendido à interface de Entidade, ou seja, T herda a interface
 */
public class Arquivo<T extends Entidade> {

    // Dados
    RandomAccessFile arquivo; // Ponteiro de acesso aleatório para arquivo
    String nomeArquivo; // Nome do arquivo
    int TAM_CABECALHO = 12; // Tamanho do cabeçalho de dados
    Constructor<T> construtor; // Classe de construtor para instanciar tipos genéricos

    /**
     * Construtor
     * @param nomeArquivo // Nome do arquivo
     * @param construtor // Construtor do tipo genérico
     * @throws Exception // Tratamento de erros
     */
    public Arquivo(String nomeArquivo, Constructor<T> construtor) throws Exception {

        this.nomeArquivo = nomeArquivo;
        this.construtor = construtor;

        arquivo = new RandomAccessFile("./dados/"+nomeArquivo+".db", "rw");
        if(arquivo.length()<TAM_CABECALHO) {
            arquivo.writeInt(0);
            arquivo.writeLong(-1);
        }
    }

    /**
     * Método para criar Entidade em arquivo
     * @param entidade // Dado genérico
     * @throws Exception Tratamento de erros
     */
    public void create(T entidade) throws Exception {

        // Obtem o ID para esta entidade
        arquivo.seek(0);
        int novoId = arquivo.readInt()+1;
        arquivo.seek(0);
        arquivo.writeInt(novoId);
        entidade.setID(novoId);

        // Escreve o novo registro no fim do arquivo
        byte[] vb = entidade.toByteArray();
        long pos = buscaVazio(vb.length); // Busca espaço vazio
        if(pos == -1) {

            // Insere no final se não houver espaço vazio
            arquivo.seek(arquivo.length());
            arquivo.writeByte(' ');
            arquivo.writeShort(vb.length);
            arquivo.write(vb);
        } else {

            // Insere na posição vazia
            arquivo.seek(pos);
            arquivo.writeByte(' ');
            arquivo.skipBytes(2);
            arquivo.write(vb);
        }

    }

    // Ler dado genérico 
    public T read(int id) throws Exception {

        arquivo.seek(TAM_CABECALHO); // Move para final do cabeçalho

        while(arquivo.getFilePointer() < arquivo.length()) { // Percorre arquivo

            byte lapide = arquivo.readByte(); // Lê byte
            short tam = arquivo.readShort(); // Lê tamanho

            if(lapide==' ') {

                // Se estiver ativo obtem o vetor de bytes e instancia objeto
                byte[] vb = new byte[tam];
                arquivo.read(vb);
                T entidade = construtor.newInstance();
                entidade.fromByteArray(vb);
                if(entidade.getID() == id) {
                    return entidade;
                }
            } else {

                // Senão pula
                arquivo.skipBytes(tam);
            }
        }
        return null;
    }

    /**
     * Método para atualizar uma entidade
     * @param novaEntidade Novo dado
     * @return Sucesso ou falha
     * @throws Exception Tratamento de excessões
     */
    public boolean update(T novaEntidade) throws Exception {
        arquivo.seek(TAM_CABECALHO);
        while(arquivo.getFilePointer() < arquivo.length()) {

            long pos = arquivo.getFilePointer(); // Obtém posição do arquivo
            byte lapide = arquivo.readByte(); // Byte lápide
            short tam = arquivo.readShort(); // Tamanho a ser lido

            
            if(lapide==' ') {
                byte[] vb = new byte[tam];
                arquivo.read(vb);
                T entidade = construtor.newInstance();
                entidade.fromByteArray(vb);
                if(entidade.getID() == novaEntidade.getID()) {
                    byte[] vb2 = novaEntidade.toByteArray();
                    int tam2 = vb2.length;
                    if(tam2 <= tam) {
                        arquivo.seek(pos+3);
                        arquivo.write(vb2);
                    } else {
                        arquivo.seek(pos);
                        arquivo.writeByte('*');
                        insereVazio(pos, tam);

                        long novaPos = buscaVazio(tam2);
                        if(novaPos == -1) {
                            arquivo.seek(arquivo.length());
                            arquivo.writeByte(' ');
                            arquivo.writeShort(tam2);
                            arquivo.write(vb2);
                        } else {
                            arquivo.seek(novaPos);
                            arquivo.writeByte(' ');
                            arquivo.skipBytes(2);
                            arquivo.write(vb2);
                        }
                    }
                    return true;
                }
            } else {
                arquivo.skipBytes(tam);
            }
        }
        return false;
    }
    
    public boolean delete(int id) throws Exception {
        arquivo.seek(TAM_CABECALHO);
        while(arquivo.getFilePointer() < arquivo.length()) {
            long pos = arquivo.getFilePointer();
            byte lapide = arquivo.readByte();
            short tam = arquivo.readShort();
            if(lapide==' ') {
                byte[] vb = new byte[tam];
                arquivo.read(vb);
                T entidade = construtor.newInstance();
                entidade.fromByteArray(vb);
                if(entidade.getID() == id) {
                    arquivo.seek(pos);
                    arquivo.writeByte('*');
                    insereVazio(pos, tam);
                    return true;
                }
            } else {
                arquivo.skipBytes(tam);
            }
        }
        return false;
    }

    public void close() throws Exception {
        arquivo.close();
    }

    public void insereVazio(long pos, int tam) {

    }

    public long buscaVazio(int tam) {

        return -1;
    }

} 