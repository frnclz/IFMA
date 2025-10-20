package atvdpratica01.q14;

public class CalculoDeDescontos implements Handler{
    private Handler proximo;
    @Override
    public void processar(Pedido pedido) {
        System.out.printf("\nCálculo de descontos - Pedido: %s%n",pedido.getId());
        if(!pedido.isEstoqueDisponivel()){
            System.out.println("Pulando cálculo - Estoque indisponível");
            return;
        }
        double valorOriginal = pedido.getValorTotal();
        double desocnto = calcularDesconto(valorOriginal);
        double valorComDesconto = valorOriginal - desocnto;

        pedido.setValorComDesconto(valorComDesconto);
        pedido.setStatus("DESCONTO_APLICADO");

        System.out.printf("Pedido aplicado com desconto: R$ %.2f%n",valorComDesconto);
        System.out.printf("Valor Original: R$ %.2f%n",valorOriginal);
        System.out.printf("Valor do Desconto: R$ %.2f%n",desocnto);
        if (proximo != null) {
            proximo.processar(pedido);
        }
    }
    private double calcularDesconto(double valor){
        if (valor > 1000) return valor * 0.15;
        if (valor > 500) return valor * 0.10;
        if (valor > 200) return valor * 0.05;
        return 0.0;
    }

    @Override
    public void setProximoHandler(Handler proximo) {
        this.proximo = proximo;
    }
}
