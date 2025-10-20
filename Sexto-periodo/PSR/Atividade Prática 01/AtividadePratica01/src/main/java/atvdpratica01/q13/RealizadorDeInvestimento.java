package atvdpratica01.q13;

public class RealizadorDeInvestimento {
    public  void investir(ContaBancaria conta, EstrategiaDeInvestimento estrategia){
        double saldoAtual = conta.getSaldo();

        if(saldoAtual <=0){
            System.out.println("Saldo Insuficiente");
        }
        System.out.printf("Saldo anterior: R$ %.2f%%n",saldoAtual);
        System.out.printf("Estratégia: %s",estrategia.getClass().getSimpleName());

        double retornoBruto = estrategia.calcularRetorno(saldoAtual);
        System.out.printf("Retorno de R$ %.2f%",retornoBruto);

        double imposto = retornoBruto * 0.25;
        double retornoLiquido = retornoBruto * 0.75;
        System.out.printf("Imposto (25%%): R$ %.2f%",imposto);
        System.out.printf("Retorno Líquido (75%%): R$ %.2f%",retornoLiquido);

        conta.depositar(retornoLiquido);
    }

}
