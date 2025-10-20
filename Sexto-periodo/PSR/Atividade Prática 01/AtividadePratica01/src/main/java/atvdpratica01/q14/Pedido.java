package atvdpratica01.q14;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private List<Item> itens;
    private double valorTotal;
    private double valorComDesconto;
    private boolean estoqueDisponivel;
    private boolean pagamentoProcessado;
    private boolean enviado;
    private String status;

    public Pedido(String id) {
        this.id = id;
        this.itens = new ArrayList<>();
        this.status = "CRIADO";
    }
    public void adicionarItem(String produto, double preco, int quantidade) {
        this.itens.add(new Item(produto, preco, quantidade));
        this.valorTotal += preco *quantidade;
    }

    public String getId() {
        return id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    public boolean isEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(boolean estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public boolean isPagamentoProcessado() {
        return pagamentoProcessado;
    }

    public void setPagamentoProcessado(boolean pagamentoProcessado) {
        this.pagamentoProcessado = pagamentoProcessado;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Pedido %s - Status: %s - Total: R$ %.2f", id, status, valorTotal);
    }
}
