package ifma.edu.transportadora.repository;

import ifma.edu.transportadora.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DistanciaDAO extends DAO<Distancia, Integer> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transportadora-PU");
    public DistanciaDAO() {
        super(Distancia.class);
    }

    // Método para encontrar a distância entre as duas cidades
    public Distancia findDistancia(Cidade cidadeOrigem, Cidade cidadeDestino) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Distancia> query = em.createQuery(
                    "SELECT d FROM Distancia d WHERE d.origem = :origem AND d.destino = :destino",
                    Distancia.class);
            query.setParameter("origem", cidadeOrigem);
            query.setParameter("destino", cidadeDestino);

            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}