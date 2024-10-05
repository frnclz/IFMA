package ifma.edu.transportadora.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Funcionario extends PessoaFisica {
    @Column(unique = true)
    private int matricula;

    @OneToMany(mappedBy = "funcionario")
    private List<Dependente> dependentes;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
}

