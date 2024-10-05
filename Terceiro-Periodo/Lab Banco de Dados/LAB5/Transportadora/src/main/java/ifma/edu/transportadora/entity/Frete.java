package ifma.edu.transportadora.entity;

import ifma.edu.transportadora.repository.DistanciaDAO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private int numeroNotaFiscal;
    private BigDecimal valorKmRodado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Cidade cidadeOrigem;

    @ManyToOne
    private Cidade cidadeDestino;

    @ManyToOne
    private CategoriaFrete categoriaFrete;

    @OneToMany(mappedBy = "frete")
    private List<ItemFrete> itens;

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

    public BigDecimal getValorKmRodado() {
        return valorKmRodado;
    }

    public void setValorKmRodado(BigDecimal valorKmRodado) {
        this.valorKmRodado = valorKmRodado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public CategoriaFrete getCategoriaFrete() {
        return categoriaFrete;
    }

    public void setCategoriaFrete(CategoriaFrete categoriaFrete) {
        this.categoriaFrete = categoriaFrete;
    }

    public List<ItemFrete> getItens() {
        return itens;
    }

    public void setItens(List<ItemFrete> itens) {
        this.itens = itens;
    }

    // Método para calcular o valor do frete
    public BigDecimal calcularFrete(DistanciaDAO distanciaDAO) {
        // Buscando a distância entre a cidade de origem e a cidade de destino
        Distancia distancia = distanciaDAO.findDistancia(cidadeOrigem, cidadeDestino);

        // Verificar se a distância foi encontrada
        if (distancia == null) {
            throw new IllegalArgumentException("Distância entre as cidades não encontrada.");
        }

        // Multiplica o valor do Km rodado pela distância
        BigDecimal valorTotal = valorKmRodado.multiply(new BigDecimal(distancia.getQuilometros()));

        // Obtendo o percentual adicional como BigDecimal e convertendo para float
        float percentualAdicional = categoriaFrete.getPercentualAdicional();

        // Convertendo o percentual para BigDecimal ao fazer o cálculo final
        valorTotal = valorTotal.multiply(BigDecimal.valueOf(1.0f + percentualAdicional));

        return valorTotal;
    }


}
