package ifma.edu.transportadora.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T, ID> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transportadora-PU");
    private Class<T> entityClass;

    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T findById(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
        } finally {
            em.close();
        }
    }
}