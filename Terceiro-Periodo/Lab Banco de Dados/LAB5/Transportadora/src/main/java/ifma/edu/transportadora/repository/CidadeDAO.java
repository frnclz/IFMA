package ifma.edu.transportadora.repository;

import ifma.edu.transportadora.entity.Cidade;

public class CidadeDAO extends DAO<Cidade, Integer> {
    public CidadeDAO() {
        super(Cidade.class);
    }
}