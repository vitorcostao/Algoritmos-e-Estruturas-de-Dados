package service;

import java.util.ArrayList;
import java.util.List;

import model.Produto;
import model.Lista;
import model.ProdutoLista;

public class ArquivoProdutoLista extends Arquivo<ProdutoLista> {

    public ArquivoProdutoLista() throws Exception {
        super("produto_lista", ProdutoLista.class.getConstructor());
    }

    /**
     * Associa um produto a uma lista
     */
    public int associarProdutoLista(int idProduto, int idLista) throws Exception {
        ProdutoLista pl = new ProdutoLista();
        pl.setIdProduto(idProduto);
        pl.setIdLista(idLista);
        return super.create(pl);
    }

    /**
     * Remove a associação entre produto e lista
     */
    public boolean desassociarProdutoLista(int idProduto, int idLista) throws Exception {
        List<ProdutoLista> relacoes = listarTodasAssociacoes();
        for (ProdutoLista pl : relacoes) {
            if (pl.getIdProduto() == idProduto && pl.getIdLista() == idLista) {
                return super.delete(pl.getId());
            }
        }
        return false;
    }

    /**
     * Lista todos os produtos associados a uma lista
     */
    public List<Integer> listarProdutosPorLista(int idLista) throws Exception {
        List<Integer> produtos = new ArrayList<>();
        List<ProdutoLista> relacoes = listarTodasAssociacoes();
        for (ProdutoLista pl : relacoes) {
            if (pl.getIdLista() == idLista) {
                produtos.add(pl.getIdProduto());
            }
        }
        return produtos;
    }

    /**
     * Lista todas as listas associadas a um produto
     */
    public List<Integer> listarListasPorProduto(int idProduto) throws Exception {
        List<Integer> listas = new ArrayList<>();
        List<ProdutoLista> relacoes = listarTodasAssociacoes();
        for (ProdutoLista pl : relacoes) {
            if (pl.getIdProduto() == idProduto) {
                listas.add(pl.getIdLista());
            }
        }
        return listas;
    }

    /**
     * Retorna todas as associações existentes
     */
    private List<ProdutoLista> listarTodasAssociacoes() throws Exception {
        List<ProdutoLista> relacoes = new ArrayList<>();
        for (int i = 1; i <= super.getUltimoId(); i++) {
            ProdutoLista pl = super.read(i);
            if (pl != null) {
                relacoes.add(pl);
            }
        }
        return relacoes;
    }
}
