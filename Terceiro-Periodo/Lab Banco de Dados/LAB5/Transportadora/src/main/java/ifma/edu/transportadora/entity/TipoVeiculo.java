package ifma.edu.transportadora.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private float pesoMaximo;

    @OneToMany(mappedBy = "tipoVeiculo")
    private List<Veiculo> veiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}

