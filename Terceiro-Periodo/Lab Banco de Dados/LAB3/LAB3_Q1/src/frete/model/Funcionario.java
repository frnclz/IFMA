package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Funcionario extends PessoaFisica{
    private int matricula;
    private List<Dependente> dependentes;
    private Filial filial;

    public Funcionario(String nome, int matricula, String email, String telefone, String cpf) {
        super(nome, email, telefone, cpf);
        this.matricula = matricula;
    }
    
    public Funcionario() {
        this.dependentes = new ArrayList<Dependente>();
    }
    
    public Funcionario(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void add(Dependente dependentes) {
        this.dependentes.add(dependentes);
    }

    public Filial getFilial() {
        return filial;
    }
    
    public Funcionario(Filial filial){
        this.filial = filial;
        this.filial.getFuncionarios().add(this);
    }
}
