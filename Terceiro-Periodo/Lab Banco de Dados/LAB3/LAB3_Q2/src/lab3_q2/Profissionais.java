package lab3_q2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Profissionais {
    private String nome, profissao, telefone1, telefone2, OBS;
    private float valorHora;

    private List<ServicosImoveis> servicos;
    private List<Locacao> locacoes;
    
    public Profissionais(){
        this.locacoes = new ArrayList<Locacao>();
        this.servicos = new ArrayList<ServicosImoveis>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }
    
    public void add(Locacao locacoes){
        this.locacoes.add(locacoes);
    }

    public List<ServicosImoveis> getServicos() {
        return servicos;
    }
    
    public void addServicos(ServicosImoveis servicos){
        this.servicos.add(servicos);
    }
}
