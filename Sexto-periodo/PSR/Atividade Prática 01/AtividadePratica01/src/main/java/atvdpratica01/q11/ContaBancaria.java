package atvdpratica01.q11;

public class ContaBancaria {
    int numero;
    int agencia;
    double saldo = 0.0;

    public ContaBancaria(int numero, int agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return agencia + "-" + numero;
    }

    public void depositar(double valor){
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        this.saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado na conta %s-%s%n",
                valor, agencia, numero);
        System.out.printf("Novo saldo: R$ %.2f%n", saldo);
    }
}
