package repository;
import entity.Klant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class KlantRepository {
    private EntityManager entityManager;
    private Klant klant;

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
    public Klant getKlant(Long id) {
        Klant klant1 = null;
        try{
            entityManager.getTransaction().begin();
            String jpql = "select k from Klant k where k.id = :id";
            TypedQuery<Klant> klant = entityManager.createQuery(jpql, Klant.class);
            klant1 = klant.setParameter("id", id).getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant1;
    }
    public Klant findKlantByid(Long id) {
        Klant klant = entityManager.find(Klant.class, id);
        if (klant == null) {
            throw new EntityNotFoundException("Can't find klant for ID "
                    + id);
        }
        return klant;
    }

//    public Klant createKlant1(String first_name, String last_name, String email) {
//        klant = new Klant();
//        klant.setFirst_name(first_name);
//        klant.setLast_name(last_name);
//        klant.setEmail(email);
//        return createKlant(klant);
//    }
//    public void deleteKlant1(Long id) {
//        try {
//            entityManager.getTransaction().begin();
//            klant = findKlantByid(id);
//            entityManager.remove(klant);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//    }
//    public Klant updateKlant1(Long id, String first_name, String last_name, String email) {
//        try {
//            entityManager.getTransaction().begin();
//            klant = findKlantByid(id);
//            klant.setFirst_name(first_name);
//            klant.setLast_name(last_name);
//            klant.setEmail(email);
//            entityManager.persist(klant);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return klant;
//    }
//    public Klant updateEmail(Long id, String email) {
//        try {
//            entityManager.getTransaction().begin();
//            klant = findKlantByid(id);
//            klant.setEmail(email);
//            entityManager.persist(klant);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return klant;
//    }
//    public Klant updateName(Long id, String first_name, String last_name) {
//        try {
//            entityManager.getTransaction().begin();
//            klant = findKlantByid(id);
//            klant.setFirst_name(first_name);
//            klant.setLast_name(last_name);
//            entityManager.persist(klant);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return klant;
//    }
}
