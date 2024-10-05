package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.ServicoImovel;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class ServicoImovelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(ServicoImovel servicoImovel) {
        entityManager.persist(servicoImovel);
    }

    public ServicoImovel buscarPorId(Integer id) {
        return entityManager.find(ServicoImovel.class, id);
    }

    public List<ServicoImovel> listarPorImovel(Integer imovelId) {
        return entityManager.createQuery("FROM ServicoImovel WHERE imovel.id = :imovelId", ServicoImovel.class)
                .setParameter("imovelId", imovelId)
                .getResultList();
    }
}
