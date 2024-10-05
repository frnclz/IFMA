package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.TipoImovel;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class TipoImovelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(TipoImovel tipoImovel) {
        entityManager.persist(tipoImovel);
    }

    public TipoImovel buscarPorId(Integer id) {
        return entityManager.find(TipoImovel.class, id);
    }

    public List<TipoImovel> listarTodos() {
        return entityManager.createQuery("FROM TipoImovel", TipoImovel.class).getResultList();
    }
}
