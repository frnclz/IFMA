package ifma.edu.transportadora.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente extends PessoaFisica {
    private String contato;
    private boolean ativo;

    @OneToMany(mappedBy = "cliente")
    private List<Frete> fretes;

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }
}

