import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.repository.ImovelRepository;
import ifma.edu.imobiliaria.service.ImovelService;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class CadastroImoveis {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Imobiliaria-PU");
        ImovelRepository imovelRepository = new ImovelRepository();
        ImovelService imovelService = new ImovelService(imovelRepository);

        // Inserir um novo imóvel
        Imovel imovel = new Imovel();
        imovel.setLogradouro("Rua das Palmeiras, 456");
        imovel.setBairro("Centro");
        imovel.setCep("54321-987");
        imovel.setMetragem(120);
        imovel.setDormitorios((byte) 3);
        imovel.setBanheiros((byte) 2);
        imovel.setSuites((byte) 1);
        imovel.setVagasGaragem((byte) 1);
        imovel.setValorAluguelSugerido(BigDecimal.valueOf(1800.00));
        imovel.setObs("Apartamento novo");

        imovelService.salvar(imovel);

        // Atualizar o imóvel
        imovel.setValorAluguelSugerido(BigDecimal.valueOf(1900.00));
        imovelService.atualizar(imovel);

        // Listar todos os imóveis
        List<Imovel> imoveis = imovelService.listarTodos();
        imoveis.forEach(i -> System.out.println("Imóvel ID: " + i.getId() + ", Valor: " + i.getValorAluguelSugerido()));

        // Fechar EntityManagerFactory
        emf.close();
    }
}
