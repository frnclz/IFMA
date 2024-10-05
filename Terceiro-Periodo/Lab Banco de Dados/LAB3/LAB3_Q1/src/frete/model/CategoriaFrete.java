package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class CategoriaFrete {
    private String nome, decricao;
    private float percentualAdicional;
    
    private List<Frete> fretes;
    
    public CategoriaFrete(){
        this.fretes = new ArrayList<Frete>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public float getPercentualAdicional() {
        return percentualAdicional;
    }

    public void setPercentualAdicional(float percentualAdicional) {
        this.percentualAdicional = percentualAdicional;
    }

    public List<Frete> getFretes() {
        return fretes;
    }
    
    public void add(Frete frete){
        this.fretes.add(frete);
    }
}
