package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.repository.ImovelRepository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class ImovelService {
    private ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public void salvar(Imovel imovel) {
        imovelRepository.salvar(imovel);
    }

    public void atualizar(Imovel imovel) {
        imovelRepository.atualizar(imovel);
    }

    public Imovel buscarPorId(int id) {
        return imovelRepository.buscarPorId(id);
    }

    public List<Imovel> listarTodos() {
        return imovelRepository.listarTodos();
    }
}
