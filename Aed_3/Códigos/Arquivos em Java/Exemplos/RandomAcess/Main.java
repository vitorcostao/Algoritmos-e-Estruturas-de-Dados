import java.io.RandomAccessFile;

/**
 * Classe RandomAccessFile possui auxiliares para leitura/escrita.
 */
public class Main {
    
    public static void main(String[] args) throws Exception{

        RandomAccessFile arq = new RandomAccessFile("carro.db", "rw");
        Carro carro = new Carro(0, "a", 12);

        arq.seek(0);
        byte[] vetor = carro.toByteArray();
        arq.write(vetor);

        arq.seek(0);
        Carro carro1 = new Carro();
        carro1.id = arq.readInt();
        carro1.nome = arq.readUTF();
        carro1.preco = arq.readFloat();

        System.out.println(carro1);

    }
}