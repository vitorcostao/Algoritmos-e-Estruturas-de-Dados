package service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import interfaces.RegistroHashExtensivel;

public class ParGTINId implements RegistroHashExtensivel<ParGTINId> {

    private String GTIN;
    private int id;
    private short TAMANHO = 44; // tamanho fixo para o índice

    public ParGTINId() {
        this("", -1);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public ParGTINId(String GTIN, int id) {
        try {
            this.GTIN = GTIN;
            this.id = id;
            if (GTIN.getBytes().length + 4 > TAMANHO)
                throw new Exception("Número de caracteres do GTIN maior que o permitido. Os dados serão cortados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return Math.abs(this.GTIN.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ParGTINId other = (ParGTINId) obj;
        return this.id == other.id &&
               (this.GTIN == null ? other.GTIN == null : this.GTIN.equals(other.GTIN));
    }

    @Override
    public short size() {
        return this.TAMANHO;
    }

    @Override
    public String toString() {
        return this.GTIN + ";" + this.id;
    }

    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(GTIN);
        dos.writeInt(id);
        byte[] bs = baos.toByteArray();
        byte[] bs2 = new byte[TAMANHO];
        for (int i = 0; i < TAMANHO; i++)
            bs2[i] = ' ';
        for (int i = 0; i < bs.length && i < TAMANHO; i++)
            bs2[i] = bs[i];
        return bs2;
    }

    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        this.GTIN = dis.readUTF();
        this.id = dis.readInt();
    }

    public static int hash(String GTIN) {
        return Math.abs(GTIN.hashCode());
    }
}
