package ifma.edu.transportadora.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uf;
    private String nome;
    private String estado;

    @OneToMany(mappedBy = "cidadeOrigem")
    private List<Frete> fretesOrigem;

    @OneToMany(mappedBy = "cidadeDestino")
    private List<Frete> fretesDestino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Frete> getFretesOrigem() {
        return fretesOrigem;
    }

    public void setFretesOrigem(List<Frete> fretesOrigem) {
        this.fretesOrigem = fretesOrigem;
    }

    public List<Frete> getFretesDestino() {
        return fretesDestino;
    }

    public void setFretesDestino(List<Frete> fretesDestino) {
        this.fretesDestino = fretesDestino;
    }
}

