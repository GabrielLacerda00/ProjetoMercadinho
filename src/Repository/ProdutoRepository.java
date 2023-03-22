package Repository;

import java.util.HashMap;
import java.util.Map;

import exemplo.Produto;

public class ProdutoRepository {
	
   Map<String,Produto> catalogo = new HashMap<String, Produto>();
   
   public void addProduto(Produto produto) {
	   catalogo.put(produto.getId(), produto);
   }
   
   public void atualizaCatalogo(String nome, String novoNome, String novoFabricante) {
	   //produto.setNome(novoNome);
	   //produto.setFabricante(novoFabricante);
   }
   
   
   
   public void removerProduto() {
	   
   }
   
   public void recuperarProduto() {
	   
   }
   
   

}
