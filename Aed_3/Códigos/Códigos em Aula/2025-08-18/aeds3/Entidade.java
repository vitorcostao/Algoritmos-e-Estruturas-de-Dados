package aeds3;

/**
 * Interface de Entidade a ser implementada
 * 
 * -> Aqui contém funções a serem implementadas em cada registro para armazenar em arquivo
 */
public interface Entidade {

    // Métodos
    public int getID(); // Obter ID
    public void setID(int id); // Setar ID
    public byte[] toByteArray() throws Exception; // Converter para vetor de bytes
    public void fromByteArray(byte[] vb) throws Exception; // Processar vetor de bytes
}
