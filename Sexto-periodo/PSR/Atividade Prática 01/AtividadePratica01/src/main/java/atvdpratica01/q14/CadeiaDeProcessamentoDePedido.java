package atvdpratica01.q14;

public class CadeiaDeProcessamentoDePedido {
    private Handler primeiro;
    private Handler ultimo;

    public CadeiaDeProcessamentoDePedido() {
        VerificacaoDeEstoque estoque = new VerificacaoDeEstoque();
        CalculoDeDescontos desconto = new CalculoDeDescontos();
        ProcessamentoDePagamento pagamento = new ProcessamentoDePagamento();
        EnvioDoPedido envio = new EnvioDoPedido();

        estoque.setProximoHandler(desconto);
        desconto.setProximoHandler(pagamento);
        pagamento.setProximoHandler(envio);

        this.primeiro = estoque;
        this.ultimo = envio;
    }
    public void processarPedido(Pedido pedido) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("INICIANDO PROCESSAMENTO DO PEDIDO");
        System.out.println("=".repeat(50));

        primeiro.processar(pedido);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("STATUS FINAL: " + pedido.getStatus());
        System.out.println("=".repeat(50));
    }
}
