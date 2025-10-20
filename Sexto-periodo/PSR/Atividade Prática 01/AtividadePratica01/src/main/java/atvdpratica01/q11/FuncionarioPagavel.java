package atvdpratica01.q11;

public interface FuncionarioPagavel {
    default double calcularTotal() {
        return calcularValorBase() + calcularExtras();
    }
    double calcularValorBase();
    double calcularExtras();
    ContaBancaria getContaBancaria();
}
