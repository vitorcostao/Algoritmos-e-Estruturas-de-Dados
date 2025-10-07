package service;

import model.Produto;

public class ArquivoProduto extends Arquivo<Produto> {

    HashExtensivel<ParGTINId> indiceIndireto;

    public ArquivoProduto() throws Exception {
        super("produtos", Produto.class.getConstructor());
        
        // índice indireto para GTIN
        indiceIndireto = new HashExtensivel<>(
            ParGTINId.class.getConstructor(),
            4,
            ".\\dados\\produtos\\indiceProduto.d.db", // diretório
            ".\\dados\\produtos\\indiceProduto.c.db"  // cestos
        );
    }

    @Override
    public int create(Produto p) throws Exception {
        int id = super.create(p);
        if(p.getGTIN() != null && !p.getGTIN().isEmpty()) {
            indiceIndireto.create(new ParGTINId(p.getGTIN(), id));
        }
        return id;
    }

    public Produto read(String GTIN) throws Exception {
        ParGTINId pei = indiceIndireto.read(ParGTINId.hash(GTIN));
        if(pei == null)
            return null;
        return read(pei.getId());
    }

    public boolean delete(String GTIN) throws Exception {
        ParGTINId pei = indiceIndireto.read(ParGTINId.hash(GTIN));
        if(pei != null) {
            if(delete(pei.getId())) 
                return indiceIndireto.delete(ParGTINId.hash(GTIN));
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Produto p = super.read(id);
        if(p != null) {
            if(super.delete(id)) {
                if(p.getGTIN() != null && !p.getGTIN().isEmpty())
                    return indiceIndireto.delete(ParGTINId.hash(p.getGTIN()));
                return true;
            }
        }
        return false;
    }

    public boolean update(Produto novoProduto, String GTINAntigo) throws Exception {
        Produto produtoVelho = read(GTINAntigo);
        if(produtoVelho == null)
            return false;

        if(super.update(novoProduto)) {
            if (!novoProduto.getGTIN().equals(produtoVelho.getGTIN())) {
                indiceIndireto.delete(ParGTINId.hash(GTINAntigo));
                indiceIndireto.create(new ParGTINId(novoProduto.getGTIN(), novoProduto.getId()));
            }
            return true;
        }
        return false;
    }
}
