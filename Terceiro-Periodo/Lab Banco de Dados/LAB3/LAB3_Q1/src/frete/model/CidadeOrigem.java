package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class CidadeOrigem extends Cidade{
    Distancia distancia;

    public CidadeOrigem(String uf, String nome, String estado, Distancia distancia) {
        super(uf, nome, estado);
        this.fretes = new ArrayList<Frete>();
        this.distancia = distancia;
        this.distancia.getCddsOrigem().add(this);
    }
    
    private List<Frete> fretes;

    public List<Frete> getFretes() {
        return fretes;
    }
    
    public void add(Frete frete){
        this.fretes.add(frete);
    }

    public Distancia getDistancia() {
        return distancia;
    }
    
}
