import java.text.DecimalFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Carro {

    protected int id;
    protected String nome;
    protected float preco;

    Carro() {

        this.id = -1;
        this.nome = " ";
        this.preco = 0;
    }

    Carro(int id, String name, float preco) {

        this.id = id;
        this.nome = name;
        this.preco = preco;
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public String toString() {
        return "\nID: " + id +
                "\nNome: " + nome +
                "\nPreço: R$ " + df.format(preco);
    }

    public byte[] toByteArray() throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(id);
        dos.writeUTF(nome);
        dos.writeFloat(preco);

        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) throws Exception{

        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        id = dis.readInt();
        nome = dis.readUTF();
        preco = dis.readFloat();
    }
}