import java.io.*;
import java.sql.Date;
import java.time.LocalDate;

public class Codigo02 {

    public static void main(String[] args) {
        
        try { 

            // ESCRITA
            RandomAccessFile arquivo = new RandomAccessFile("./dados/dados.db", "rw");
            arquivo.writeInt(65);
            arquivo.writeByte(65);
            arquivo.writeByte('A');
            arquivo.writeChar('A');
            arquivo.writeFloat(-49.25F);
            arquivo.writeBoolean(true);
            arquivo.writeUTF("Anão");
            arquivo.write("12345678901".getBytes());
            LocalDate dia = LocalDate.of(2025, 8, 11);
            arquivo.writeInt((int)dia.toEpochDay());

            // LEITURA
            arquivo.seek(0);
            int i = arquivo.readInt();
            byte b1 = arquivo.readByte();
            byte b2 = arquivo.readByte();
            char c = arquivo.readChar();
            float f = arquivo.readFloat();
            boolean v = arquivo.readBoolean();
            String s = arquivo.readUTF();
            System.out.println(i);
            System.out.println(b1);
            byte[] l = new byte[1];
            l[0] = b2;
            System.out.println(new String(l));
            System.out.println(c);
            System.out.println(f);
            System.out.println(v);
            System.out.println(s);

            byte[] aux = new byte[11];
            arquivo.read(aux);
            String cpf = new String(aux);
            System.out.println(cpf);

            LocalDate dia2 = LocalDate.ofEpochDay(arquivo.readInt());
            System.out.println(dia2.toString());

            arquivo.close();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }


}