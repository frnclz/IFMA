package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Distancia {
    private int quilometros;
    private double adicionalKmRodado;
    
    private List<CidadeOrigem> cddsOrigem;
    private List<CidadeDestino> cddsDestino;
    
    public Distancia (){
        this.cddsOrigem = new ArrayList<CidadeOrigem>();
        this.cddsDestino = new ArrayList<CidadeDestino>();
    }

    public int getQuilometros() {
        return quilometros;
    }

    public void setQuilometros(int quilometros) {
        this.quilometros = quilometros;
    }

    public double getAdicionalKmRodado() {
        return adicionalKmRodado;
    }

    public void setAdicionalKmRodado(double adicionalKmRodado) {
        this.adicionalKmRodado = adicionalKmRodado;
    }

    public List<CidadeOrigem> getCddsOrigem() {
        return cddsOrigem;
    }
    
    public void add(CidadeOrigem cddsOrigem){
        this.cddsOrigem.add(cddsOrigem);
    }

    public List<CidadeDestino> getCddsDestino() {
        return cddsDestino;
    }
    
    public void add(CidadeDestino cddsDestino){
        this.cddsDestino.add(cddsDestino);
    }
}
