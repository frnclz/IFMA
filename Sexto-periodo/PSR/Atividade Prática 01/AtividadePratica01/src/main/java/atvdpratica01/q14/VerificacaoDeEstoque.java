package atvdpratica01.q14;

import java.util.Random;

public class VerificacaoDeEstoque implements Handler{
    private Handler proximo;
    private Random random = new Random();

    @Override
    public void processar(Pedido pedido) {
        System.out.printf("Verificação de estoque - Pedido %s%n", pedido.getId());
        boolean temEstoque = random.nextDouble() > 0.2;
        pedido.setEstoqueDisponivel(temEstoque);

        if (temEstoque) {
            System.out.println("\nEstoque disponível para todos os itens");
            pedido.setStatus("ESTOQUE_VERIFICADO");
            if (proximo != null){
                proximo.processar(pedido);
            }
        } else {
            System.out.println("Estoque insuficiente para alguns itens");
            pedido.setStatus("CANCELADO - SEM ESTOQUE");
        }
    }

    @Override
    public void setProximoHandler(Handler proximo) {
        this.proximo = proximo;
    }
}
