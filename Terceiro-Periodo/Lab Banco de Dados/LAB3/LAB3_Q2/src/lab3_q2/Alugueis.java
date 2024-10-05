package lab3_q2;

import java.util.Date;

/**
 *
 * @author franc
 */
public class Alugueis {
    private Date dataVencimento;
    private float valorPago;
    private Date dataPagamento;
    private String OBS;

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }
    
    
}
