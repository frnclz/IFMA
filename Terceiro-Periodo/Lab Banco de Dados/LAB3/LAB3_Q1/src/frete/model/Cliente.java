package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Cliente extends PessoaFisica{
    private String contato;
    private boolean status;

    private List<Frete> fretes;
    
    public Cliente(){
        this.fretes = new ArrayList<Frete>();
    }
    
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Frete> getFretes() {
        return fretes;
    }
    
    public void add(Frete fretes){
        this.fretes.add(fretes);
    }
    
}
