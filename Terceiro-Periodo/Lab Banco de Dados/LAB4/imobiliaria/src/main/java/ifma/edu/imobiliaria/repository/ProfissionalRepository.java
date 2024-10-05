package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Profissional;

import javax.persistence.*;
import java.util.List;

public class ProfissionalRepository {
    private EntityManager em;

    public ProfissionalRepository() {
        this.em = Persistence.createEntityManagerFactory("Imobiliaria-PU").createEntityManager();
    }

    public void salvar(Profissional profissional) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(profissional);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public void atualizar(Profissional profissional) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(profissional);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public Profissional buscarPorId(int id) {
        return em.find(Profissional.class, id);
    }

    public List<Profissional> listarTodos() {
        TypedQuery<Profissional> query = em.createQuery("SELECT p FROM Profissional p", Profissional.class);
        return query.getResultList();
    }
}
