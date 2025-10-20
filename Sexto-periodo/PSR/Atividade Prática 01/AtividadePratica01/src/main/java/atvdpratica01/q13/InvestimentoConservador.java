package atvdpratica01.q13;

public class InvestimentoConservador implements EstrategiaDeInvestimento{

    @Override
    public double calcularRetorno(double valorInvestido) {
        return valorInvestido * 0.008;
    }
}
