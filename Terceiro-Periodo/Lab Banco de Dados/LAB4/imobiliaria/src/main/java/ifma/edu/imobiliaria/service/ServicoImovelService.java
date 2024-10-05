package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.ServicoImovel;
import ifma.edu.imobiliaria.repository.ServicoImovelRepository;

import java.util.List;

public class ServicoImovelService {
    private ServicoImovelRepository servicoImovelRepository;

    public ServicoImovelService(ServicoImovelRepository servicoImovelRepository) {
        this.servicoImovelRepository = servicoImovelRepository;
    }

    public void salvar(ServicoImovel servicoImovel) {
        servicoImovelRepository.salvar(servicoImovel);
    }

    public ServicoImovel buscarPorId(Integer id) {
        return servicoImovelRepository.buscarPorId(id);
    }

    public List<ServicoImovel> listarPorImovel(Integer imovelId) {
        return servicoImovelRepository.listarPorImovel(imovelId);
    }
}
