package frete.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
class Filial {
    private String nome, edenreco, telefone;
    
    private List<Funcionario> funcionarios;
    private List<Veiculo> veiculos;

    public Filial() {
        this.funcionarios = new ArrayList<Funcionario>();
        this.veiculos = new ArrayList<Veiculo>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdenreco() {
        return edenreco;
    }

    public void setEdenreco(String edenreco) {
        this.edenreco = edenreco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void add(Funcionario funcionarios){
        this.funcionarios.add(funcionarios);
    }
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    public void add(Veiculo veiculos){
        this.veiculos.add(veiculos);
    }
}
