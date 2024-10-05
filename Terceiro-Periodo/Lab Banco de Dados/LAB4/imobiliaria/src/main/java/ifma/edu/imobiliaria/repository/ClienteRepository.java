package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Clientes;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

public class ClienteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Clientes cliente) {
        entityManager.persist(cliente);
    }

    public Clientes buscarPorId(Integer id) {
        return entityManager.find(Clientes.class, id);
    }

    public List<Clientes> listarTodos() {
        return entityManager.createQuery("FROM Clientes", Clientes.class).getResultList();
    }

    public Clientes buscarPorCpf(String cpf) {
        return entityManager.createQuery("FROM Clientes WHERE cpf = :cpf", Clientes.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }
}
