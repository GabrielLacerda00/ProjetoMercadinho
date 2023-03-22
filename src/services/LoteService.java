package services;

import model.Lote;
import model.Produto;
import repository.LoteRepository;
import repository.ProdutoRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.LoteDTO;
import exception.LoteNotFoundException;


public class LoteService {
	
		
		private LoteRepository loteRep;
		
		
		private ProdutoRepository produtoRep;

		private Lote lote;
		private int quantidadeDeProdutoEmLote;
		private Produto produto;


		public String addLote(LoteDTO loteDTO) throws ParseException {
			produto = this.produtoRep.getProd(loteDTO.getIdProduto());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataDeValidade = sdf.parse(loteDTO.getDataValidade());
			Lote lot = new Lote(produto, loteDTO.getQuantidade(),dataDeValidade);
			this.loteRep.addLote(lot);
			return lot.getId();
		}

		public Lote getLoteById(String id)throws LoteNotFoundException {
			lote = this.loteRep.getLote(id);
			if(lote == null) throw new LoteNotFoundException("Lote não encontrado");
			return lote;
		}

		public Lote getLotePorProduto(Produto produto) throws LoteNotFoundException{
			for (Lote lotee:this.loteRep.getAll()) {
				if (lote.getProduto().equals(produto)){
					 lote = lotee;
				}
			}
			return lote;
		}

		public void deletLoteById(String id) throws LoteNotFoundException {
			lote = this.loteRep.delLot(id);
			if (lote == null){
				throw new LoteNotFoundException("Lote com id: " + id + "não existe");
			}
			this.loteRep.delLot(id);
		}

		public ArrayList<Lote> listarLotes() { return new ArrayList<Lote>(loteRep.getAll()); }

		public String updateLote(String id,int quantidade) throws LoteNotFoundException{
			lote = this.loteRep.getLote(id);
			if (lote == null) throw new LoteNotFoundException("Lote "+ id +" não encontrado!");
			lote.setQuantidade(quantidade);
			return lote.getId();
		}

		public int pegaQuantidadeDoProdutoEmLote(Produto produto){
			for (Lote lote : this.loteRep.getAll()) {
				Produto produtoEmLote = lote.getProduto();
				if (produtoEmLote.equals(produto)) {
					quantidadeDeProdutoEmLote = lote.getQuantidade();
				}
			}
			return quantidadeDeProdutoEmLote;
		}

		public List<Produto> pegaProdutosComLote(){
			List<Produto> prods = new ArrayList<Produto>();
			for (Lote lote : this.loteRep.getAll()) {
				Produto produto = lote.getProduto();
				prods.add(lote.getProduto());
			}
			return (prods);
		}

		public Produto pegaProdutoEmLotes(String id){
			for (Lote lote : this.loteRep.getAll()) {
				String produtoId = lote.getProduto().getId();
				if (id.equals(produtoId)) {
					produto = lote.getProduto();
				}
			}
			return produto;
		}

		public void alteraQuantidadeProdutoEmLote(String id,int quantidade){
			for (Lote lote : this.loteRep.getAll()) {
				String produtoId = lote.getProduto().getId();
				int produtoQuantidade = lote.getQuantidade();
				if (produtoId.equals(id)){
					lote.setQuantidade(produtoQuantidade - quantidade);
				}
			}
		}

		public void alteraQuantidadProdutoEmLote(String id,int quantidade){
			for (Lote lote : this.loteRep.getAll()) {
				String produtoId = lote.getProduto().getId();
				int produtoQuantidade = lote.getQuantidade();
				if (produtoId.equals(id)){
					lote.setQuantidade(produtoQuantidade + quantidade);
				}
			}
		}
	}

