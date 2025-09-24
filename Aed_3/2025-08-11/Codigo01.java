import java.io.*;

/**
 * Classe representado acesso sequencial em arquivo
 */
public class Codigo01 {

    public static void main(String[] args) {
        
        try { 

            // ESCRITA
            FileOutputStream arquivo = new FileOutputStream("./dados/dados.db");
            DataOutputStream dos = new DataOutputStream(arquivo);

            /**
             * DataOutputStream é uma classe para registrar dados em fluxo de saída
             * 
             */
            dos.writeInt(65);
            dos.writeByte(65);
            dos.writeByte('A');
            dos.writeChar('A');
            dos.writeFloat(-49.25F);
            dos.writeBoolean(true);
            dos.writeUTF("Conceição");
            dos.close();
            arquivo.close();

            // LEITURA
            FileInputStream arquivo1 = new FileInputStream("./dados/dados.db");
            DataInputStream dis = new DataInputStream(arquivo1);

            /**
             * DataInputStream é uma classe para obter dados em fluxo de entrada
             * 
             */
            int i = dis.readInt();
            byte b1 = dis.readByte();
            byte b2 = dis.readByte();
            char c = dis.readChar();
            float f = dis.readFloat();
            boolean v = dis.readBoolean();
            String s = dis.readUTF();
            System.out.println(i);
            System.out.println(b1);

            // Arranjo de bytes
            byte[] l = new byte[1];
            l[0] = b2;

            
            System.out.println(new String(l));
            System.out.println(c);
            System.out.println(f);
            System.out.println(v);
            System.out.println(s);
            dis.close();
            arquivo1.close();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }


}