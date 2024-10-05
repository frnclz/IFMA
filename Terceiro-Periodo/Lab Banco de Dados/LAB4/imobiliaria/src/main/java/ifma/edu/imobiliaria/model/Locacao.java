package ifma.edu.imobiliaria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Locacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_inquilino")
    private Clientes inquilino;

    @ManyToOne
    @JoinColumn(name = "id_imovel")
    private Imovel imovel;

    private BigDecimal valorAluguel;
    private BigDecimal percentualMulta;
    private Byte diaVencimento;
    private Date dataInicio, dataFinal;
    private Boolean ativo;
    private String obs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getInquilino() {
        return inquilino;
    }

    public void setInquilino() {
        this.inquilino = inquilino;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public BigDecimal getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(BigDecimal percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public Byte getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Byte diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel() {
        this.imovel = imovel;
    }

    public void setInquilino(Clientes inquilino) {
        this.inquilino = inquilino;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
}
