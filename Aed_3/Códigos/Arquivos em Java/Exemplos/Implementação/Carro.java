import java.io.*;
import java.text.DecimalFormat;

public class Carro implements Registro {

    protected int id;
    protected String nome;
    protected float preco;

    @SuppressWarnings("unused")
    Carro(int id, String name, float preco) {

        this.id = id;
        this.nome = name;
        this.preco = preco;
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public String getNome() {

        return nome;
    }

    @Override
    public int getId() {

        return id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNome: " + nome +
                "\nPreço: R$ " + df.format(preco);
    }

    @Override
    public byte[] toByteArray() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(id);
        dos.writeUTF(nome);
        dos.writeFloat(preco);

        return baos.toByteArray();
    }

    @Override
    public void fromByteArray(byte[] ba) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        id = dis.readInt();
        nome = dis.readUTF();
        preco = dis.readFloat();
    }
}