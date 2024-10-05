import ifma.edu.imobiliaria.model.Profissional;
import ifma.edu.imobiliaria.repository.ProfissionalRepository;
import ifma.edu.imobiliaria.service.ProfissionalService;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class CadastroProfissional {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Imobiliaria-PU");
        ProfissionalRepository profissionalRepository = new ProfissionalRepository();
        ProfissionalService profissionalService = new ProfissionalService(profissionalRepository);

        // Inserir um novo profissional
        Profissional profissional = new Profissional();
        profissional.setNome("Maria Oliveira");
        profissional.setProfissao("Eletricista");
        profissional.setTelefone1("987654321");
        profissional.setTelefone2("987654322");
        profissional.setValorHora(BigDecimal.valueOf(100.00));
        profissional.setObs("Profissional qualificado");

        profissionalService.salvar(profissional);

        // Atualizar o profissional
        profissional.setValorHora(BigDecimal.valueOf(110.00));
        profissionalService.atualizar(profissional);

        // Listar todos os profissionais
        List<Profissional> profissionais = profissionalService.listarTodos();
        profissionais.forEach(p -> System.out.println("Profissional ID: " + p.getId() + ", Nome: " + p.getNome()));

        // Fechar EntityManagerFactory
        emf.close();
    }
}
