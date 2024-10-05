package lab3_q2;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author franc
 */
public class ServicosImoveis {
    private Date dataServico;
    private double valorTotal;
    private Blob notaFiscal;
    private String caminhoMedia;
    private String OBS;

    private Imoveis imovel;
    private Profissionais profissional;

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Blob getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Blob notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getCaminhoMedia() {
        return caminhoMedia;
    }

    public void setCaminhoMedia(String caminhoMedia) {
        this.caminhoMedia = caminhoMedia;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public Imoveis getImovel() {
        return imovel;
    }
    
    public ServicosImoveis (Imoveis imovel, Profissionais profissional){
        this.imovel = imovel;
        this.imovel.getServicos().add(this);
        this.profissional.getServicos().add(this);
    }

    public Profissionais getProfissional() {
        return profissional;
    }
    
}
