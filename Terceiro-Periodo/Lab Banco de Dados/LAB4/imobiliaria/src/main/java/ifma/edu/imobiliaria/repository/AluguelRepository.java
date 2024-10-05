package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Aluguel;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class AluguelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Aluguel aluguel) {
        entityManager.persist(aluguel);
    }

    public Aluguel buscarPorId(Integer id) {
        return entityManager.find(Aluguel.class, id);
    }

    public List<Aluguel> listarPorInquilino(String nomeInquilino) {
        return entityManager.createQuery("SELECT a FROM Aluguel a JOIN a.locacao l JOIN l.inquilino c WHERE c.nome = :nome", Aluguel.class)
                .setParameter("nome", nomeInquilino)
                .getResultList();
    }

    public List<Aluguel> listarAlugueisComAtraso() {
        return entityManager.createQuery("FROM Aluguel WHERE dataPagamento > dataVencimento", Aluguel.class).getResultList();
    }
}
