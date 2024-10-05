package ifma.edu.transportadora.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Veiculo {
    @Id
    private String numeroPlaca;

    @ManyToOne
    private Filial filial;

    @ManyToOne
    private TipoVeiculo tipoVeiculo;

    @OneToMany(mappedBy = "veiculo")
    private List<Frete> fretes;

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }
}

