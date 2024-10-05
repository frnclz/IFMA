package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Frete {
    private int codigo;
    private int numeroNotaFiscal;
    private double valorKmRodado;
    
    private Veiculo veiculos;
    private Cliente clientes;
    private CategoriaFrete categoria;
    private List<ItemFrete> itens;
    private CidadeOrigem cidadeOrigem;
    private CidadeDestino cidadeDestino;
    
    public Frete(){
        this.itens = new ArrayList<ItemFrete>();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(int numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public double getValorKmRodado() {
        return valorKmRodado;
    }

    public void setValorKmRodado(double valorKmRodado) {
        this.valorKmRodado = valorKmRodado;
    }

    public Veiculo getVeiculos() {
        return veiculos;
    }
    
    public Frete(Veiculo veiculos){
        this.veiculos = veiculos;
        this.veiculos.getFretes().add(this);
    }

    public Cliente getClientes() {
        return clientes;
    }
    
    public Frete(Cliente clientes){
        this.clientes = clientes;
        this.clientes.getFretes().add(this);
    }

    public CategoriaFrete getCategoria() {
        return categoria;
    }
    
    public Frete (CategoriaFrete categoria){
        this.categoria = categoria;
        this.categoria.getFretes().add(this);
    }

    public List<ItemFrete> getItens() {
        return itens;
    }
    
    public void add(ItemFrete itens){
        this.itens.add(itens);
    }

    public CidadeOrigem getCidadeOrigem() {
        return cidadeOrigem;
    }

    public Frete (CidadeOrigem cidadeOrigem, CidadeDestino cidadeDestino){
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeOrigem.getFretes().add(this);
        this.cidadeDestino = cidadeDestino;
        this.cidadeDestino.getFretes().add(this);
    }

    public CidadeDestino getCidadeDestino() {
        return cidadeDestino;
    }
    
    public double calcularFrete(int distanciaPercorrida){
        return this.valorKmRodado * distanciaPercorrida;
    }
    
}
