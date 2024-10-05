package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Locacao;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class LocacaoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Locacao locacao) {
        entityManager.persist(locacao);
    }

    public void atualizar(Locacao locacao) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(locacao);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public Locacao buscarPorId(Integer id) {
        return entityManager.find(Locacao.class, id);
    }

    public List<Locacao> listarPorInquilino(Integer inquilinoId) {
        return entityManager.createQuery("FROM Locacao WHERE inquilino.id = :inquilinoId", Locacao.class)
                .setParameter("inquilinoId", inquilinoId)
                .getResultList();
    }
}
