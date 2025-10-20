package atvdpratica01.q14;

import java.util.Random;

public class EnvioDoPedido implements Handler{
    private Handler proximo;
    private Random random = new Random();
    @Override
    public void processar(Pedido pedido) {
        System.out.printf("\n Envio Do Pedido - Pedido: %s%n",pedido.getId());

        if (!pedido.isEstoqueDisponivel() || !pedido.isPagamentoProcessado()) {
            System.out.println("Pulando envio - Pedido não está pronto para envio");
            return;
        }
        boolean enviadoComSucesso = random.nextDouble() > 0.05;
        pedido.setEnviado(enviadoComSucesso);
        if (enviadoComSucesso) {
            System.out.println("Pedido enviado com sucesso!");
            pedido.setStatus("ENVIADO");
            String codigoRastreamento = gerarCodigoRastreamento();
            System.out.printf("Código de rastreamento: %s%n",codigoRastreamento);
        } else{
            System.out.println("Erro no envio do pedido");
            pedido.setStatus("ERRO_NO_ENVIO");
        }
        if(proximo != null){
            proximo.processar(pedido);
        }

    }
    private String gerarCodigoRastreamento(){
        return "KJH" + System.currentTimeMillis();
    }

    @Override
    public void setProximoHandler(Handler proximo) {
        this.proximo = proximo;
    }
}
