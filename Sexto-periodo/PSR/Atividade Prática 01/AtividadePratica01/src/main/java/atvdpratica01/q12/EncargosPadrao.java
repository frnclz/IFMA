package atvdpratica01.q12;

public class EncargosPadrao implements CalculadorEncargos{
    @Override
    public double calcularEncargos(double valor) {
        return valor * 0.01;
    }
}
