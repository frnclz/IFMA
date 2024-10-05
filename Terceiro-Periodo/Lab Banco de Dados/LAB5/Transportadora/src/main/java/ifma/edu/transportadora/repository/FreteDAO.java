package ifma.edu.transportadora.repository;
import ifma.edu.transportadora.entity.*;

import javax.persistence.*;
import java.util.List;

public class FreteDAO extends DAO<Frete, Integer> {
    public FreteDAO() {
        super(Frete.class);
    }

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transportadora-PU");
    public List<Frete> findFretesByCliente(ClienteDAO cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Frete> query = em.createQuery(
                    "SELECT f FROM Frete f WHERE f.cliente = :cliente",
                    Frete.class);
            query.setParameter("cliente", cliente);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}