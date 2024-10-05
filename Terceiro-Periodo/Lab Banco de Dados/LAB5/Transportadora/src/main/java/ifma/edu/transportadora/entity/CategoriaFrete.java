package ifma.edu.transportadora.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class CategoriaFrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private float percentualAdicional;

    @OneToMany(mappedBy = "categoriaFrete")
    private List<Frete> fretes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }
}

