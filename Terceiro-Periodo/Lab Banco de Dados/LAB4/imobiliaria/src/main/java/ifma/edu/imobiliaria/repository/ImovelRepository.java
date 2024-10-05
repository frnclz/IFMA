package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Imovel;

import javax.persistence.*;
import java.util.List;

public class ImovelRepository {
    private EntityManager em;

    public ImovelRepository() {
        this.em = Persistence.createEntityManagerFactory("Imobiliaria-PU").createEntityManager();
    }

    public void salvar(Imovel imovel) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(imovel);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public void atualizar(Imovel imovel) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(imovel);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public Imovel buscarPorId(int id) {
        return em.find(Imovel.class, id);
    }

    public List<Imovel> listarTodos() {
        TypedQuery<Imovel> query = em.createQuery("SELECT i FROM Imovel i", Imovel.class);
        return query.getResultList();
    }
}
