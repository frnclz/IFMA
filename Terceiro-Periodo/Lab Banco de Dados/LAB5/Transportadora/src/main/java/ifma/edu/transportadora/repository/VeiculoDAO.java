package ifma.edu.transportadora.repository;

import ifma.edu.transportadora.entity.Veiculo;

public class VeiculoDAO extends DAO<Veiculo, Integer> {
    public VeiculoDAO() {
        super(Veiculo.class);
    }
}