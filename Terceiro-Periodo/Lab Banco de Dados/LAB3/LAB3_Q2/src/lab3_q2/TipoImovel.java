package lab3_q2;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author franc
 */
public class TipoImovel {
    private String descricao;
    private boolean condominio;

    private List<Imoveis> imoveis;

    public TipoImovel() {
        this.imoveis = new ArrayList<Imoveis>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCondominio() {
        return condominio;
    }

    public void setCondominio(boolean condominio) {
        this.condominio = condominio;
    }

    public List<Imoveis> getImoveis() {
        return imoveis;
    }
    public void add (Imoveis imoveis){
        this.imoveis.add(imoveis);
    }
}
