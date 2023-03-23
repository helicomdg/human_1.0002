package repository;
import entity.CarDealership;
import entity.Klant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CarDealershipRepository {
    private EntityManager entityManager;

    public CarDealershipRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CarDealership> getDealerships() {
        String query = "select d from CarDealership d";
        TypedQuery<CarDealership> typedQuery = entityManager.createQuery(query, CarDealership.class);
        List<CarDealership> dealerships = typedQuery.getResultList();
        return dealerships;
    }

    public CarDealership createCarDealership(CarDealership carDealership) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(carDealership);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership;
    }

    public CarDealership deleteCardealership(CarDealership carDealership) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(CarDealership.class, carDealership.getId());
            if (carDealership != null) entityManager.remove(carDealership);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership;
    }
    public CarDealership updateCardealership(CarDealership carDealership) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(CarDealership.class, carDealership.getId());
            entityManager.merge(carDealership);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership;
    }
    public CarDealership getCarDealership(int id) {
        CarDealership carDealership1 = null;
        try{
            entityManager.getTransaction().begin();
            String jpql = "select d from CarDealership d where d.id = :id";
            TypedQuery<CarDealership> carDealership = entityManager.createQuery(jpql, CarDealership.class);
            carDealership1 = carDealership.setParameter("id", id).getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return carDealership1;
    }
    public CarDealership findCarDealershipByid(int id) {
        CarDealership carDealership = entityManager.find(CarDealership.class, id);
        if (carDealership == null) {
            throw new EntityNotFoundException("Can't find carDealership for ID "
                    + id);
        }
        return carDealership;
    }
}
