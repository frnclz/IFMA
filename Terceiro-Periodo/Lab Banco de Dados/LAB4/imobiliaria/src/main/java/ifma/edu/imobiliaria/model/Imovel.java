package ifma.edu.imobiliaria.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Imoveis")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proprietario")
    private Clientes proprietario;

    @ManyToOne @JoinColumn(name = "id_tipo_imovel")
    private TipoImovel tipoImovel;

    private String bairro;
    private String cep;
    private Integer metragem;
    private Byte dormitorios;
    private Byte suites;
    private Byte vagasGaragem;
    private BigDecimal valorAluguelSugerido;
    private String obs;
    private String logradouro;
    private Byte banheiros;

    private Boolean ativo;  // se o imóvel está ativo/disponível

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getProprietario() {
        return proprietario;
    }

    public void setProprietario(Clientes proprietario) {
        this.proprietario = proprietario;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getMetragem() {
        return metragem;
    }

    public void setMetragem(Integer metragem) {
        this.metragem = metragem;
    }

    public Byte getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Byte dormitorios) {
        this.dormitorios = dormitorios;
    }

    public Byte getSuites() {
        return suites;
    }

    public void setSuites(Byte suites) {
        this.suites = suites;
    }

    public Byte getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(Byte vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public BigDecimal getValorAluguelSugerido() {
        return valorAluguelSugerido;
    }

    public void setValorAluguelSugerido(BigDecimal valorAluguelSugerido) {
        this.valorAluguelSugerido = valorAluguelSugerido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Byte getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Byte banheiros) {
        this.banheiros = banheiros;
    }
}
