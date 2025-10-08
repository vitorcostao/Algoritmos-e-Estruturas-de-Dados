import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ParNomeId implements RegistroHashExtensivel<ParNomeId> {
    
    private String nome; // chave
    private int id;     // valor
    private final short TAMANHO = 15;

    public ParNomeId() {
        this.nome = " ";
        this.id = -1;
    }

    public ParNomeId(String nome, int id) throws Exception {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

 
    @Override
    public int hashCode() {
        return hash(this.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ParNomeId other = (ParNomeId) obj;
        return id == other.id && nome.equals(other.nome);
    }

    @Override
    public short size() {
        return this.TAMANHO;
    }

    @Override
    public String toString() {
        return "("+this.nome + ";" + this.id+")";
    }

    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.write(this.nome.getBytes());
        dos.writeInt(this.id);
        return baos.toByteArray();
    }

    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        byte[] b = new byte[11];
        dis.read(b);
        this.nome = new String(b);
        this.id = dis.readInt();
    }

    public static int hash(String nome) throws IllegalArgumentException {
        // Certifique-se de que o CPF contém exatamente 11 dígitos
        if (nome.length() != 11 || !nome.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }

        // Converter o CPF para um número inteiro longo
        long cpfLong = Long.parseLong(nome);

        // Aplicar uma função de hash usando um número primo grande
        int hashValue = (int) (cpfLong % (int)(1e9 + 7));

        // Retornar um valor positivo
        return Math.abs(hashValue);
    }


}