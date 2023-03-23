package repository;
import entity.Car;
import entity.Klant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CarRepository {
        private EntityManager entityManager;

        public CarRepository(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public List<Car> getCars() {
            String query = "select c from Car c";
            TypedQuery<Car> typedQuery = entityManager.createQuery(query, Car.class);
            List<Car> cars = typedQuery.getResultList();
            return cars;
        }
        public Car createCar(Car car){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(car);
                entityManager.getTransaction().commit();
            }
            catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
            }
            return car;
        }
    public Car deleteCar(Car car){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Car.class, car.getId());
            if(car != null)  entityManager.remove(car);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return car;
    }
    public Car updateCar(Car car){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Car.class, car.getId());
            entityManager.merge(car);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return car;
    }
    public Car getCar(int id) {
        Car car1 = null;
        try{
            entityManager.getTransaction().begin();
            String jpql = "select c from Car c where c.id = :id";
            TypedQuery<Car> car = entityManager.createQuery(jpql, Car.class);
            car1 = car.setParameter("id", id).getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return car1;
    }
    public Car findCarByid(int id) {
        Car car = entityManager.find(Car.class, id);
        if (car == null) {
            throw new EntityNotFoundException("Can't find car for ID "
                    + id);
        }
        return car;
    }

}
