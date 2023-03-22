package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Lote;
import model.Produto;

import java.util.List;



public class LoteRepository {

	int quantidadeDeProdutoEmLote;
	Produto produto;
	
	private Map<String, Lote> lotes = new HashMap<String, Lote>();
	
	public Collection<Lote> getAll() {
		return this.lotes.values();
	}
	
	public Lote getLote(String id) {
		return this.lotes.get(id);
	}
	
	public Lote delLot(String id) {
		return this.lotes.remove(id);
	}
	
	public void editLote(Lote lote) {
		this.lotes.replace(lote.getId(), lote);
	}
	
	public String addLote(Lote lote) {
		this.lotes.put(lote.getId(), lote);
		return lote.getId();
	}


}
