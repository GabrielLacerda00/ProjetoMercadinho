package Services;

import Model.Lote;
import Repository.LoteRepository;

public class LoteService {
    private Repository.LoteRepository loteRep;

    public LoteService(Repository.LoteRepository rep) {
        this.loteRep = rep;
    }

    public void addLote(Lote lote) {
        this.loteRep.adicionarLote(lote);
    }
}