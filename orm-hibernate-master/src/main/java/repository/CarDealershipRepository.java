package repository;
import entity.CarDealership;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CarDealershipRepository {
    private EntityManager entityManager;

    public CarDealershipRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CarDealership> getCarDealership() {
        String query = "select d from CarDealership d";
        TypedQuery<CarDealership> typedQuery = entityManager.createQuery(query, CarDealership.class);
        List<CarDealership> carDealershipList = typedQuery.getResultList();
        return carDealershipList;
    }

    public CarDealership createCarDealership(CarDealership carDealership) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(carDealership);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return carDealership;
    }

    public CarDealership deleteCardealership(CarDealership carDealership){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(CarDealership.class, carDealership.getId());
            if(carDealership != null)  entityManager.remove(carDealership);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership;
    }


    public CarDealership updateCardealership(CarDealership carDealership){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(CarDealership.class, carDealership.getId());
            entityManager.merge(carDealership);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership;
    }

}
