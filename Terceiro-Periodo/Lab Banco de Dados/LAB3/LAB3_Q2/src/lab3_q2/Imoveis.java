package lab3_q2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Imoveis {
    private String nomeImovel;

    private String endereco, bairro, zonaCidade, pontoReferencia, caminhoMedia, memorialDescritivo, requisitosInquilino, OBS;
    private int cep, dormitorios, banheiros, suites, vagasGaragem;
    private Point posiacaoGeografica;
    private double metragem, valorAluguelSugerido, valorIPTU;
    
    private TipoImovel tipo;
    private List<Locacao> locacoes;
    private List<ServicosImoveis> servicos;
    private Cliente cliente;
    
    public Imoveis(){
        this.servicos = new ArrayList<ServicosImoveis>();
        this.locacoes = new ArrayList<Locacao>();
    }

    public String getNomeImovel() {
        return nomeImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getZonaCidade() {
        return zonaCidade;
    }

    public void setZonaCidade(String zonaCidade) {
        this.zonaCidade = zonaCidade;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getCaminhoMedia() {
        return caminhoMedia;
    }

    public void setCaminhoMedia(String caminhoMedia) {
        this.caminhoMedia = caminhoMedia;
    }

    public String getMemorialDescritivo() {
        return memorialDescritivo;
    }

    public void setMemorialDescritivo(String memorialDescritivo) {
        this.memorialDescritivo = memorialDescritivo;
    }

    public String getRequisitosInquilino() {
        return requisitosInquilino;
    }

    public void setRequisitosInquilino(String requisitosInquilino) {
        this.requisitosInquilino = requisitosInquilino;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public Point getPosiacaoGeografica() {
        return posiacaoGeografica;
    }

    public void setPosiacaoGeografica(Point posiacaoGeografica) {
        this.posiacaoGeografica = posiacaoGeografica;
    }

    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public double getValorAluguelSugerido() {
        return valorAluguelSugerido;
    }

    public void setValorAluguelSugerido(double valorAluguelSugerido) {
        this.valorAluguelSugerido = valorAluguelSugerido;
    }

    public double getValorIPTU() {
        return valorIPTU;
    }

    public void setValorIPTU(double valorIPTU) {
        this.valorIPTU = valorIPTU;
    }

    public TipoImovel getTipo() {
        return tipo;
    }
    
    public Imoveis (TipoImovel tipo, Cliente cliente){
        this.tipo = tipo;
        this.tipo.getImoveis().add(this);
        this.cliente = cliente;
        this.cliente.getImoveis().add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ServicosImoveis> getServicos() {
        return servicos;
    }
    
    public void add(ServicosImoveis servicos){
        this.servicos.add(servicos);
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }
    
    public void addLocacao(Locacao locacoes){
        this.locacoes.add(locacoes);
    }
}
