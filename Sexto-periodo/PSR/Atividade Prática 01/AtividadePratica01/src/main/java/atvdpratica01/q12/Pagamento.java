package atvdpratica01.q12;

import java.util.Calendar;

public class Pagamento {
    private String favorecido;
    private String formaDePagamento;
    private Movimentacao movimentacao;

    public Pagamento(Double valor, Conta conta, Calendar data, String favorecido, String formaDePagamento) {
        this.favorecido = favorecido;
        this.formaDePagamento = formaDePagamento;
        this.movimentacao = new Movimentacao(valor, conta, data, new EncargosPadrao());
    }

    public double getEncargos() {
        return movimentacao.getEncargos();
    }

    public double getValorLiquido() {
        return movimentacao.getValorLiquido();
    }
    // getters e setters
}
