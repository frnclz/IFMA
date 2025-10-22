package atvdpratica01.q14;

import java.util.Random;

public class ProcessamentoDePagamento implements Handler{
    private Handler proximo;
    private Random rand = new Random();
    @Override
    public void processar(Pedido pedido) {
        System.out.println("\nProcessamento de Pagamento - Pedido: "+pedido.getId());
        if(!pedido.isEstoqueDisponivel()){
            System.out.println("Pulando pagamento - Estoque indisponível");
            return;
        }
        double valorAPagar = pedido.getValorComDesconto();
        boolean pagamentoAprovado = rand.nextDouble() > 0.1;
        pedido.setPagamentoProcessado(pagamentoAprovado);

        if(pagamentoAprovado) {
            System.out.printf("Pagamento de R$ %.2f aprovado%n",valorAPagar);
            pedido.setStatus("PAGAMENTO_APROVADO");

            if (proximo != null) {
                proximo.processar(pedido);
            } else {
                System.out.println("Pagamento recusado");
                pedido.setStatus("PAGAMENTO_RECUSADO");
            }
        }
    }

    @Override
    public void setProximoHandler(Handler proximo) {
        this.proximo = proximo;
    }
}
