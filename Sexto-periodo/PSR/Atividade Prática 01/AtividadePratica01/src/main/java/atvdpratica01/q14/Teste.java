package atvdpratica01.q14;

public class Teste {
    public static void main(String[] args) {
        CadeiaDeProcessamentoDePedido processador = new CadeiaDeProcessamentoDePedido();

        System.out.println("SISTEMA DE PROCESSAMENTO DE PEDIDOS");
        System.out.println("=====================================\n");

        //Primeiro teste
        System.out.println("1º TESTE - PEDIDO NORMAL");
        Pedido pedido1 = new Pedido("PED-001");
        pedido1.adicionarItem("Smartphone", 1500.0, 1);
        pedido1.adicionarItem("Fone de Ouvido", 200.0, 1);
        processador.processarPedido(pedido1);

        System.out.println("\n\n2º TESTE - PEDIDO COM VALOR ALTO");
        Pedido pedido2 = new Pedido("PED-002");
        pedido2.adicionarItem("Notebook Gamer", 3500.0, 1);
        pedido2.adicionarItem("Mouse", 80.0, 1);
        pedido2.adicionarItem("Teclado", 120.0, 1);
        processador.processarPedido(pedido2);

        System.out.println("\n\n3º TESTE - PEDIDO PEQUENO");
        Pedido pedido3 = new Pedido("PED-003");
        pedido3.adicionarItem("Cabo USB", 25.0, 2);
        processador.processarPedido(pedido3);

        System.out.println("\n\n4º TESTE - MÚLTIPLOS PEDIDOS");
        for (int i = 4; i <= 6; i++) {
            Pedido pedido = new Pedido("PED-00" + i);
            pedido.adicionarItem("Produto " + i, 300.0 * i, 1);
            processador.processarPedido(pedido);
        }
    }
}
