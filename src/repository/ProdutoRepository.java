package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Produto;

public class ProdutoRepository {
	
   Map<String,Produto> catalogo = new HashMap<String, Produto>();
   
   public String addProduto(Produto produto) {
	   catalogo.put(produto.getId(), produto);
	   return produto.getId();
   }
   
   public void atualizaCatalogo(String nome, String novoNome, String novoFabricante) {
	   //produto.setNome(novoNome);
	   //produto.setFabricante(novoFabricante);
   }
   
   
   
   public void removerProduto() {
	   
   }
   
   public void recuperarProduto() {
	   
   }
   
   public Collection<Produto> getAll() {
		return catalogo.values();
	}
   

}
