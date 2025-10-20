package atvdpratica01.q13;

import java.util.Random;

public class InvestimentoModerado implements EstrategiaDeInvestimento{
    private Random random = new Random();
    @Override
    public double calcularRetorno(double valorInvestido) {
        if(random.nextDouble() > 0.50){
            return valorInvestido * 0.025;
        } else {
            return valorInvestido * 0.007;
        }
    }
}
