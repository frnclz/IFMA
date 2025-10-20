package atvdpratica01.q12;

import java.util.Calendar;

public class Movimentacao {
    private double valor;
    private Conta conta;
    private Calendar data;
    private CalculadorEncargos calculadorEncargos;
    public Movimentacao(double valor, Conta conta, Calendar data, CalculadorEncargos calculadorEncargos) {
        this.valor = valor;
        this.conta = conta;
        this.data = data;
        this.calculadorEncargos = calculadorEncargos;
    }

    public double getEncargos() {
        return calculadorEncargos.calcularEncargos(valor);
    }

    public double getValorLiquido() {
        return valor - getEncargos();
    }

    // getters e setters

}
