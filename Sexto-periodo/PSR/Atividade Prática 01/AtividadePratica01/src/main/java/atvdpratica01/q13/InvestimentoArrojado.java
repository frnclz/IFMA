package atvdpratica01.q13;

import java.util.Random;

public class InvestimentoArrojado implements EstrategiaDeInvestimento{
    private Random random = new Random();
    @Override
    public double calcularRetorno(double valorInvestido) {
        double chance = random.nextDouble();

        if(chance < 0.20){
            return valorInvestido * 0.05;
        } else if (chance <= 0.50){
            return valorInvestido * 0.03;
        } else {
            return valorInvestido * 0.0006;
        }
    }
}
