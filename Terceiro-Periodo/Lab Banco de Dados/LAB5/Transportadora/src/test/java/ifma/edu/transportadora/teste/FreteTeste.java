package ifma.edu.transportadora.teste;

import ifma.edu.transportadora.entity.*;
import ifma.edu.transportadora.repository.*;
import ifma.edu.transportadora.service.FreteService;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class FreteTeste {
    public static void main(String[] args) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        TipoVeiculoDAO tipoVeiculoDAO = new TipoVeiculoDAO();
        CategoriaFreteDAO categoriaFreteDAO = new CategoriaFreteDAO();
        DistanciaDAO distanciaDAO = new DistanciaDAO();
        FreteDAO freteDAO = new FreteDAO();

        Cidade cidadeOrigem = new Cidade();
        cidadeOrigem.setNome("São Paulo");
        cidadeOrigem.setUf("SP");
        cidadeOrigem.setEstado("São Paulo");
        cidadeDAO.save(cidadeOrigem);

        Cidade cidadeDestino = new Cidade();
        cidadeDestino.setNome("Niterói");
        cidadeDestino.setUf("RJ");
        cidadeDestino.setEstado("Rio de Janeiro");
        cidadeDAO.save(cidadeDestino);

        Cliente cliente = new Cliente();
        cliente.setNome("Fernando da Silva");
        cliente.setEmail("fernandof@gmail.com");
        cliente.setTelefone("98932156745");
        cliente.setCpf("256.780.963-15");
        clienteDAO.save(cliente);

        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setDescricao("Carreta");
        tipoVeiculo.setPesoMaximo(18000.0f);
        tipoVeiculoDAO.save(tipoVeiculo);

        Veiculo veiculo = new Veiculo();
        veiculo.setNumeroPlaca("FCJ-1506");
        veiculo.setTipoVeiculo(tipoVeiculo);
        veiculoDAO.save(veiculo);

        CategoriaFrete categoriaFrete = new CategoriaFrete();
        categoriaFrete.setNome("Entrega Rápida");
        categoriaFrete.setDescricao("Entrega em até 5 dias úteis");
        categoriaFrete.setPercentualAdicional(0.10F);
        categoriaFreteDAO.save(categoriaFrete);

        Distancia distancia = new Distancia();
        distancia.setOrigem(cidadeOrigem);
        distancia.setDestino(cidadeDestino);
        distancia.setQuilometros(400);
        distanciaDAO.save(distancia);

        Frete frete = new Frete();
        frete.setCliente(cliente);
        frete.setCidadeOrigem(cidadeOrigem);
        frete.setCidadeDestino(cidadeDestino);
        frete.setVeiculo(veiculo);
        frete.setCategoriaFrete(categoriaFrete);
        frete.setValorKmRodado(new BigDecimal("5.00"));
        freteDAO.save(frete);

        FreteService freteService = new FreteService();

        BigDecimal valorFrete = freteService.calcularValorFrete(frete);

        System.out.println("Valor total do frete: " + valorFrete);
    }
}