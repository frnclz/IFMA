package frete.model;

import java.util.List;

/**
 *
 * @author franc
 */
public class Veiculo {
    private String numerPlaca;
    
    private Filial filial;
    private TipoVeiculo tipoDoVeiculo;
    private List<Frete> fretes;

    public Veiculo(Filial filial, TipoVeiculo tipoDoVeiculo) {
        this.filial = filial;
        this.tipoDoVeiculo = tipoDoVeiculo;
    }
    public Veiculo(Filial filial){
        this.filial = filial;
        this.filial.getVeiculos().add(this);
    }
    public String getNumerPlaca() {
        return numerPlaca;
    }

    public void setNumerPlaca(String numerPlaca) {
        this.numerPlaca = numerPlaca;
    }

    public Filial getFilial() {
        return filial;
    }
  
    public TipoVeiculo getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }
    
    public List<Frete> getFretes() {
        return fretes;
    }
    public void add(Frete fretes){
        this.fretes.add(fretes);
    }
    
    
}
