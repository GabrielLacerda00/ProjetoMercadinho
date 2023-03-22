package Services;


import Repository.ProdutoRepository;
import Repository.LoteRepository;
import DTO.ProdutoDTO;
import Model.Lote;
import Model.Produto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


public class ProdutoService {

	
	private LoteRepository loteRep;
	
	
	private ProdutoRepository prodRep;

	public List<Produto> listarProdutos() {
		return new ArrayList<Produto>(prodRep.getAll());
	}

	public List<Produto> listarProdutos(String nome) {
		return getProdsByName(nome, this.prodRep.getAll());
	}

	private List<Produto> getProdsByName(String nome, Collection<Produto> prods) {
		List<Produto> prodsResult = new ArrayList<Produto>();
		for (Produto produto : prods) {
			if(nome == null || produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
				prodsResult.add(produto);
			}
		}	
		return(prodsResult);
	}

	public String addProduto(ProdutoDTO prodDTO) {
		Produto produto = new Produto(prodDTO.getNome(), prodDTO.getFabricante(), prodDTO.getPreco());
		
		this.prodRep.addProduto(produto);
		
		return produto.getId();
	}
	
	public Produto getProdutoById(String id) throws ProductNotFoundException {
		Produto prod =  this.prodRep.getProd(id);
		if(prod == null) throw new ProductNotFoundException("Produto: " + id + " não encontrado");

		return (prod);
	}

	public String updateProdut(String id,ProdutoDTO produtoDTO) throws ProductNotFoundException {
		Produto produto = this.prodRep.getProd(id);
		if(produto == null) throw new ProductNotFoundException("Produto: " + id + " não encontrado");

		produto.setFabricante(produtoDTO.getFabricante());
		produto.setNome(produtoDTO.getNome());
		produto.setPreco(produtoDTO.getPreco());

		this.prodRep.editProd(produto);

		return produto.getId();
	}

	public void deletProdutById(String id) throws ProductNotFoundException {
		Produto produto = this.prodRep.getProd(id);
		if (produto == null){
			throw new ProductNotFoundException("Produto com id: " + id + "não existe");
		}
		this.prodRep.delProd(id);
		deletLotDeProd(id);
	}

	private void deletLotDeProd(String idProd){
		for (Lote lot : this.loteRep.getAll() ){
			if (lot.getProduto().getId().equals(idProd)){
				this.loteRep.delLot(lot.getId());
			}
		}
	}

	public List<Produto> getProdsComLote(String nomeProduto){
		List<Produto> prods = new ArrayList<Produto>();
		for (Lote lote : this.loteRep.getAll()) {
			Produto produto = lote.getProduto();
			if (nomeProduto ==null || produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())){
				prods.add(lote.getProduto());
			}

		}
		return (prods);
	}

	public List<Produto> getProdutosEmLote(){
		List<Produto> prods = new ArrayList<Produto>();
		for (Lote lote : this.loteRep.getAll()) {
			Produto produto = lote.getProduto();
			prods.add(lote.getProduto());
		}
		return (prods);
	}

	public List<Produto> consultaProdutoPorNome(String nome) throws ProductNotFoundException{
		if (this.prodRep.getAll().isEmpty()){
			throw new ProductNotFoundException("Não existem produtos cadastrados no sistema!");
		}
		return getProdsByName(nome,this.prodRep.getAll());
	}

}
