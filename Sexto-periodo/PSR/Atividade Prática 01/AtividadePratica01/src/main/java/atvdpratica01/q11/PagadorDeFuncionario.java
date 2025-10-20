package atvdpratica01.q11;

public class PagadorDeFuncionario {
    public void pagarFuncionario(FuncionarioPagavel funcionario) {
        double total = funcionario.calcularTotal();
        funcionario.getContaBancaria().depositar(total);
    }
}
