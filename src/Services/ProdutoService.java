package Services;


import exemplo.Lote;
import exemplo.Produto;
import Repository.ProdutoRepository;
import Repository.LoteRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


public class ProdutoService {

     ProdutoRepository produtReposit;
     LoteRepository loteReposit;

     public ProdutoService( ProdutoRepository produtReposit,LoteRepository loteReposit){
         this.loteReposit = loteReposit;
         this.produtReposit = produtReposit;
     }

    public List<Produto> listaProdutsLoteByName(){
        List<Lote> produts = getProdutswithLote();
        return getProdutsWithLote(lotess);
    }

    private List<Produto>  getProdutswithLote(){
        List<Produto> produts = new ArrayList<Produto>();
        for (Lote lot : this.loteReposit.getAll()) {
            produts.add(lot.getProduto());
        }
        return(produts);
    }

    public List<Produto> listProdutoByName(String name) {
        return getProdutsByName(name,this.produtReposit.getAll());
    }

    private List<Produto> getProdutsByName(String nome, Collection<Produto> produts){
        List<Produto> listDeProdutss = new ArrayList<Produto>();
        for (Produto produto: produts){
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())){
                listDeProdutss.add(produto);
            }
            return listDeProdutss;
        }

    }

    public void adicionarProduto(Produto prod) {
        this.produtReposit.adicionarProduto(prod);
    }

}
