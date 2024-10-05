package ifma.edu.imobiliaria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "Servicos_Imovel")
@Entity
public class ServicoImovel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "id_imovel")
    private Imovel imovel;

    private Date dataServico;
    private BigDecimal valorTotal;
    private String obs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
