package atvdpratica01.q11;

public class Funcionario implements FuncionarioPagavel{
    private double salarioBase;
    private double bonificacoes;
    private ContaBancaria conta;

    public Funcionario(double salarioBase, double bonificacoes, ContaBancaria conta) {
        this.salarioBase = salarioBase;
        this.bonificacoes = bonificacoes;
        this.conta = conta;
    }

    @Override
    public double calcularValorBase() {
        return salarioBase;
    }

    @Override
    public double calcularExtras() {
        return bonificacoes;
    }

    @Override
    public ContaBancaria getContaBancaria() {
        return conta;
    }
}
