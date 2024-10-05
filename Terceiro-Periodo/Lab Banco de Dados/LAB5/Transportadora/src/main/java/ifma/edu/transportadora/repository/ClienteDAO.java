package ifma.edu.transportadora.repository;

import ifma.edu.transportadora.entity.Cliente;

public class ClienteDAO extends DAO<Cliente, Integer> {
    public ClienteDAO() {
        super(Cliente.class);
    }
}
