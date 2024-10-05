package frete.model;

/**
 *
 * @author franc
 */
public class Cidade {
    private String uf, nome, estado;

    public Cidade(String uf, String nome, String estado) {
        this.uf = uf;
        this.nome = nome;
        this.estado = estado;
    }
    

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
 
}
