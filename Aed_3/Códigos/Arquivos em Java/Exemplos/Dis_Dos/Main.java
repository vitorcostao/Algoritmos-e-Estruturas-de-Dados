import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Operações com arquivos
 * 
 * -> Leitura e escrita -> ACESSO AOS DADOS
 * 
 * A leitura de dados é um processo de entrada, visto que os dados saem do arquivo para o programa.
 * A escrita de dados é um processo de saída, visto que os dados saem do programa para o arquivo.
 * 
 * 
 * -> Análise como vetor de bytes
 * Métodos importantes:
 * 
 * 
 * 1) toByteArray:   Converte objeto em vetor de bytes
 * 
 * public byte[] toByteArray() {
 *      
 *      // Auxiliares
 *      ByteArrayOutputStream baos = new ByteArrayOutputStream();
 *      DataOutputStream dos = DataOutputStream(baos);
 * 
 *      // Armazenar dados em termos do objeto
 *      dos.writeInt(1);
 *      dos.writeUTF("1");
 * 
 *      return baos.toByteArray();
 * }
 * 
 * 
 * 
 * 2) fromByteArray: Converte vetor de bytes em objeto
 * 
 * public void fromByteArray(byte[] ba){
 *      
 *      ByteArrayInputStream bais = new ByteArrayInputStream();    
 *      DataInputStream dis = new DataInputStream(bais);
 * 
 *      dadoInt = dis.readInt();
 *      dadoString = dis.readUTF();       
 * }
 */

public class Main {
    public static void main(String[] args) {

        Carro c1 = new Carro(1, "Ford KA", 70000);
        Carro c2 = new Carro(2, "Ford Fiesta", 35000);

        System.out.println(c1);
        System.out.println(c2);

        FileOutputStream arq;
        DataOutputStream dos;

        FileInputStream arq2;
        DataInputStream dis;

        byte[] ba;

        try {

            arq = new FileOutputStream("carros.db");
            dos = new DataOutputStream(arq);
            
            // Converte dados em sequecia de bytes
            ba = c1.toByteArray();
            dos.writeInt(ba.length);
            dos.write(ba);

            ba = c2.toByteArray();
            dos.writeInt(ba.length);
            dos.write(ba);

            arq.close();

            Carro c3 = new Carro();
            Carro c4 = new Carro();
            int tam;

            arq2 = new FileInputStream("carros.db");
            dis = new DataInputStream(arq2);

            tam = dis.readInt();
            ba = new byte[tam];
            dis.read(ba);
            c3.fromByteArray(ba);
            System.out.println(c3);

            tam = dis.readInt();
            ba = new byte[tam];
            dis.read(ba);
            c4.fromByteArray(ba);
            System.out.println(c4);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
