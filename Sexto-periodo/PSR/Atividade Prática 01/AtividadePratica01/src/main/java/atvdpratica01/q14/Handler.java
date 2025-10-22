package atvdpratica01.q14;

public interface Handler {
    void processar(Pedido pedido);
    void setProximoHandler(Handler proximo);
}
