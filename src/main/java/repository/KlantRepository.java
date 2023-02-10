package repository;
import entity.Klant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class KlantRepository {

    private EntityManager entityManager;

    public KlantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Klant> getKlanten() {
        String query = "select k from Klant k";
        TypedQuery<Klant> typedQuery = entityManager.createQuery(query, Klant.class);
        List<Klant> klanten = typedQuery.getResultList();
        return klanten;
    }

    public Klant createKlant(Klant klant){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }


    public Klant deleteKlant(Klant klant){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Klant.class, klant.getId());
            if(klant != null)  entityManager.remove(klant);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }


    public Klant updateKlant(Klant klant){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Klant.class, klant.getId());
            entityManager.merge(klant);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }

}
