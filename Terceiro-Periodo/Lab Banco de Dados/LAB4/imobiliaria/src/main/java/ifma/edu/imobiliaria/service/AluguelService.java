package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Aluguel;
import ifma.edu.imobiliaria.repository.AluguelRepository;

import java.util.List;

public class AluguelService {
    private AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public void salvar(Aluguel aluguel) {
        aluguelRepository.salvar(aluguel);
    }

    public Aluguel buscarPorId(Integer id) {
        return aluguelRepository.buscarPorId(id);
    }

    public List<Aluguel> listarPorInquilino(String nomeInquilino) {
        return aluguelRepository.listarPorInquilino(nomeInquilino);
    }

    public List<Aluguel> listarAlugueisComAtraso() {
        return aluguelRepository.listarAlugueisComAtraso();
    }
}
