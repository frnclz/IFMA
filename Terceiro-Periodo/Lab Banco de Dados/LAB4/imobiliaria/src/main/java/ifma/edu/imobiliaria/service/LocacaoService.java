package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Locacao;
import ifma.edu.imobiliaria.repository.ImovelRepository;
import ifma.edu.imobiliaria.repository.LocacaoRepository;

import java.util.List;

public class LocacaoService {
    private LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public void salvar(Locacao locacao) {
        locacaoRepository.salvar(locacao);
    }

    public void atualizar(Locacao locacao) {
        locacaoRepository.atualizar(locacao);
    }

    public Locacao buscarPorId(Integer id) {
        return locacaoRepository.buscarPorId(id);
    }

    public List<Locacao> listarPorInquilino(Integer inquilinoId) {
        return locacaoRepository.listarPorInquilino(inquilinoId);
    }
}
