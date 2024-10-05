package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Profissional;
import ifma.edu.imobiliaria.repository.ProfissionalRepository;

import java.util.List;

public class ProfissionalService {
    private ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public void salvar(Profissional profissional) {
        profissionalRepository.salvar(profissional);
    }

    public void atualizar(Profissional profissional) {
        profissionalRepository.atualizar(profissional);
    }

    public Profissional buscarPorId(int id) {
        return profissionalRepository.buscarPorId(id);
    }

    public List<Profissional> listarTodos() {
        return profissionalRepository.listarTodos();
    }
}
