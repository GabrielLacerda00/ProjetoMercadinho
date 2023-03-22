package services;

import model.Lote;
import repository.LoteRepository;

public class LoteService {
    private repository.LoteRepository loteRep;

    public LoteService(repository.LoteRepository rep) {
        this.loteRep = rep;
    }

    public void addLote(Lote lote) {
        this.loteRep.adicionarLote(lote);
    }
}