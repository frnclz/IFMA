import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Imobiliaria-PU");

        EntityManagerFactory factory1 = factory;
        factory1.close();
    }
}
