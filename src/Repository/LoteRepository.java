package Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import exemplo.Lote;

public class LoteRepository {

    Map<String,Lote> catalogo = new HashMap<String, Lote>();

    public String adicionarLote(Lote lote) {
        catalogo.put(lote.getId(), lote);
        return lote.getId();
    }

    public void atualizaLote(String id, long quantidade) {
        Lote lote = pegaLote(id);
        lote.setQuantidade(quantidade);
    }

    public void removeLote(String id) {
        catalogo.remove(id);
    }

    public Lote pegaLote(String id) {
        return catalogo.get(id);
    }

    public List<Lote> listaDeLotes() {
        List<Lote> listDeLotes = new List<Lote>();
        for (Lote lot: catalogo.values()) {
            listDeLotes.add(lot);
        }
        return listDeLotes;
    }

	public Lote[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}