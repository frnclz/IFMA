package ifma.edu.transportadora.service;

import ifma.edu.transportadora.entity.*;
import ifma.edu.transportadora.repository.*;

import java.math.BigDecimal;
import java.util.List;

public class FreteService {
    private FreteDAO freteDAO = new FreteDAO();
    private DistanciaDAO distanciaDAO = new DistanciaDAO();

    // Registra um novo frete no sistema
    public void registrarFrete(Frete frete) {
        freteDAO.save(frete);
    }

    // Calcula o valor do frete com base na distância e categoria
    public BigDecimal calcularValorFrete(Frete frete) {
        Distancia distancia = distanciaDAO.findDistancia(frete.getCidadeOrigem(), frete.getCidadeDestino());
        BigDecimal valorKm = frete.getValorKmRodado().multiply(new BigDecimal(distancia.getQuilometros()));
        BigDecimal percentual = BigDecimal.valueOf(frete.getCategoriaFrete().getPercentualAdicional());
        return valorKm.multiply(BigDecimal.ONE.add(percentual));
    }

    // Retorna a lista com todos os fretes de um determinado cliente
    public List<Frete> listarFretesPorCliente(ClienteDAO cliente) {
        return freteDAO.findFretesByCliente(cliente);
    }

    // Busca o frete por ID
    public Frete buscarFretePorId(int id) {
        return freteDAO.findById(id);
    }
}
