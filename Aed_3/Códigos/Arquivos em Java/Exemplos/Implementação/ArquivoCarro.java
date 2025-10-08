
public class ArquivoCarro extends Arquivo<Carro> {

    HashExtensivel<ParNomeId> indiceIndiretoNome;

    public ArquivoCarro() throws Exception {
        super("carro", Carro.class.getConstructor());
        indiceIndiretoNome = new HashExtensivel<>(
            ParNomeId.class.getConstructor(), 
            4, 
            ".\\dados\\carro\\indiceCPF.d.db",   // diretório
            ".\\dados\\carro\\indiceCPF.c.db"    // cestos 
        );
    }

    @Override
    public int create(Carro c) throws Exception {
        int id = super.create(c);
        indiceIndiretoNome.create(new ParNomeId(c.getNome(), id));
        return id;
    }

    public Carro read(String cpf) throws Exception {
        ParNomeId pci = indiceIndiretoNome.read(ParNomeId.hash(cpf));
        if(pci == null)
            return null;
        return read(pci.getId());
    }
    
    public boolean delete(String cpf) throws Exception {
        ParNomeId pci = indiceIndiretoNome.read(ParNomeId.hash(cpf));
        if(pci != null) 
            if(delete(pci.getId())) 
                return indiceIndiretoNome.delete(ParNomeId.hash(cpf));
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Carro c = super.read(id);
        if(c != null) {
            if(super.delete(id))
                return indiceIndiretoNome.delete(ParNomeId.hash(c.getNome()));
        }
        return false;
    }

    @Override
    public boolean update(Carro novoCarro) throws Exception {
        Carro clienteVelho = read(novoCarro.getNome());
        if(super.update(novoCarro)) {
            if(novoCarro.getNome().compareTo(clienteVelho.getNome())!=0) {
                indiceIndiretoNome.delete(ParNomeId.hash(clienteVelho.getNome()));
                indiceIndiretoNome.create(new ParNomeId(novoCarro.getNome(), novoCarro.getId()));
            }
            return true;
        }
        return false;
    }
}