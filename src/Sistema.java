import Repository.ProdutoRepository;
import exemplo.Lote;
import exemplo.Produto;

public class Sistema {

	public static void main(String[] args) {
		
		Produto produto = new Produto("Leite", "Parmalat");
		Produto produto02 = new Produto("Frango", "GranjaFeliz");
		Produto produto03 = new Produto("Carne","Frigorifico");
		Lote lote = new Lote(produto, 10L);
		
		ProdutoRepository catalogo = new ProdutoRepository();
		
		catalogo.addProduto(produto);
		catalogo.addProduto(produto02);
		catalogo.addProduto(produto03);
		
		//catalogo.atualizaCatalogo(produto03, null, null);
		
		System.out.println(produto);
		System.out.println(lote);
	}
}
