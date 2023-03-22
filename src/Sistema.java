import java.util.Date;
import java.util.concurrent.ExecutionException;

import model.Lote;
import model.Produto;
import repository.LoteRepository;
import repository.ProdutoRepository;

public class Sistema {

	
	private static ProdutoRepository produtoRepository;

	
	private static LoteRepository loteRepository;


	public static void main(String[] args) throws ExecutionException {
		Date date = new Date();
		
		Produto produto01 = new Produto("Ovo","GranjaLacerda", 10.00);
		Produto produto02 = new Produto("leite em pó","Fazenda Feliz", 8.00);
		Produto produto03 = new Produto("pasta de dente","colgate",10.00);
		Produto produto04 = new Produto("pão","solar",5.00);

		produtoRepository.addProduto(produto01);
		produtoRepository.addProduto(produto02);
		produtoRepository.addProduto(produto03);
		produtoRepository.addProduto(produto04);


		Lote lote01 = new Lote(produto01, 50,date);
		Lote lote02 = new Lote(produto02,12,date);
		Lote lote03 = new Lote(produto03, 8,date);
		Lote lote04 = new Lote(produto04, 17,date);

		loteRepository.addLote(lote01);
		loteRepository.addLote(lote02);
		loteRepository.addLote(lote03);
		loteRepository.addLote(lote04);
		
		System.out.println(produto01);
		System.out.println(produto02);
		System.out.println(produto03);
		System.out.println(produto04);
		
		System.out.println(lote01);
		System.out.println(lote02);
		System.out.println(lote03);
		System.out.println(lote04);
	}
}
