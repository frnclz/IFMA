package lab3_q2;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author franc
 */
public class Locacao {
    private float valorAluguel;
    private String periodoCidade, responsavelPagamento, OBS, caminhoSituacaoImovel;
    private float percentualMulta;
    private Date diaVencimento, dataInicio, dataFim;
    private boolean ativo;
    private Blob contrato, modeloRecibo;

    private List<Alugueis> alugeis;
    private Imoveis imovel;
    private Profissionais profissional;
    private Cliente cliente;
    
    public Locacao(){
        this.alugeis = new ArrayList<Alugueis>();
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getPeriodoCidade() {
        return periodoCidade;
    }

    public void setPeriodoCidade(String periodoCidade) {
        this.periodoCidade = periodoCidade;
    }

    public String getResponsavelPagamento() {
        return responsavelPagamento;
    }

    public void setResponsavelPagamento(String responsavelPagamento) {
        this.responsavelPagamento = responsavelPagamento;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public String getCaminhoSituacaoImovel() {
        return caminhoSituacaoImovel;
    }

    public void setCaminhoSituacaoImovel(String caminhoSituacaoImovel) {
        this.caminhoSituacaoImovel = caminhoSituacaoImovel;
    }

    public float getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(float percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public Date getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Date diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Blob getContrato() {
        return contrato;
    }

    public void setContrato(Blob contrato) {
        this.contrato = contrato;
    }

    public Blob getModeloRecibo() {
        return modeloRecibo;
    }

    public void setModeloRecibo(Blob modeloRecibo) {
        this.modeloRecibo = modeloRecibo;
    }

    public Imoveis getImovel() {
        return imovel;
    }
    
    public Locacao(Imoveis imovel, Cliente cliente, Profissionais profissional){
        this.imovel = imovel;
        this.imovel.getLocacoes().add(this);
        this.cliente = cliente;
        this.cliente.getLocacoes().add(this);
        this.profissional = profissional;
        this.profissional.getLocacoes().add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Alugueis> getAlugeis() {
        return alugeis;
    }
    public void add(Alugueis alugueis){
        this.alugeis = alugeis;
    }

    public Profissionais getProfissional() {
        return profissional;
    }
    
}
