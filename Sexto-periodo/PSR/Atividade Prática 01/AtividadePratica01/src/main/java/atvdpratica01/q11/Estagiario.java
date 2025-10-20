package atvdpratica01.q11;

public class Estagiario implements FuncionarioPagavel{
    private double bolsa;
    private  double auxilio;
    private ContaBancaria conta;

    public Estagiario(double bolsa, double auxilio, ContaBancaria conta) {
        this.bolsa = bolsa;
        this.auxilio = auxilio;
        this.conta = conta;
    }

    @Override
    public double calcularValorBase() {
        return bolsa;
    }

    @Override
    public double calcularExtras() {
        return auxilio;
    }

    @Override
    public ContaBancaria getContaBancaria() {
        return conta;
    }
}
