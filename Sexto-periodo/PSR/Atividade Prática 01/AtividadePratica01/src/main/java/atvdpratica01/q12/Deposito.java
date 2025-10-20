package atvdpratica01.q12;

import java.util.Calendar;

public class Deposito {
    private String numeroEnvelope;
    private Movimentacao movimentacao;

    public Deposito(double valor, Conta conta, Calendar data, String numeroEnvelope) {
        this.movimentacao = new Movimentacao(valor, conta, data, new SemEncargos());
        this.numeroEnvelope = numeroEnvelope;
    }

    public double getEncargos() {
        return movimentacao.getEncargos();
    }

    public double getValorLiquido() {
        return movimentacao.getValorLiquido();
    }

    // getters e setters
}
