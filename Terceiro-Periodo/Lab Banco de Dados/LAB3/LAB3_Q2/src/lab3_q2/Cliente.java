package lab3_q2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Cliente {
    private String nomeCliente, cpf, rg, enderecoCompleto, telefone1, telefone2, email, dataNascimento;
    
    private List<Locacao> locacoes;
    private List<Imoveis> imoveis;
    
    public Cliente(){
        this.imoveis = new ArrayList<Imoveis>();
        this.locacoes = new ArrayList<Locacao>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Imoveis> getImoveis() {
        return imoveis;
    }
    
    public void add(Imoveis imoveis){
        this.imoveis.add(imoveis);  
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }
    
    public void addLocacao(Locacao locacoes){
        this.locacoes.add(locacoes);
    }
}
