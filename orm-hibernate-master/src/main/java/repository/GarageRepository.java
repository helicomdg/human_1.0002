package repository;
import entity.Car;
import entity.Garage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class GarageRepository {
    private EntityManager entityManager;
    private Object Garage;

    public GarageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Garage> getGarage() {
        String query = "select g from Garage g";
        TypedQuery<Garage> typedQuery = entityManager.createQuery(query, Garage.class);
        List<Garage> garageList = typedQuery.getResultList();
        return garageList;
    }

    public Car createGarage(Car garage) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(garage);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return garage;
    }

    public Garage deleteGarage(Garage garage){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Garage.class, garage.getId());
            if(Garage != null)  entityManager.remove(Garage);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return garage;
    }

    public Garage updateGarage(Garage garage){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Garage.class, garage.getId());
            entityManager.merge(garage);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return garage;
    }

}
