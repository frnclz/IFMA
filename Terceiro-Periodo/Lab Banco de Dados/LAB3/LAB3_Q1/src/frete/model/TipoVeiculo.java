package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class TipoVeiculo {
    private String descricao;
    private float pesoMaximo;
    
    private List<Veiculo> veiculos;
    
    public TipoVeiculo(){
        this.veiculos = new ArrayList<Veiculo>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(float pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    public void add(Veiculo veiculos){
        this.veiculos.add(veiculos);
    }
}
