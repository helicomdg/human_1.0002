package repository;
import entity.Car;
import jakarta.persistence.EntityManager;
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
            List<Car> carlist = typedQuery.getResultList();
            return carlist;
        }

        public Optional<Object> createCar(Car car){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(car);
                entityManager.getTransaction().commit();
            }
            catch (Exception e) {
                e.printStackTrace();
                e.printStackTrace();
//                entityManager.getTransaction().rollback();
            }
            return Optional.empty();
//            return car;
        }

    public Optional<Car> findById(Integer id) {
        Car car = entityManager.find(Car.class, id);
        return car != null ? Optional.of(car) : Optional.empty();
    }

    public Car updateCar(Car car) {
        return null;
    }

    public Car deleteCar(Car car) {
        return null;
    }

//    public void deleteById(Integer id) {
//        // Retrieve the model with this ID
//        Car car = entityManager.find(Car.class, id);
//        if (car != null) {
//            try {
//                entityManager.getTransaction().begin();
//                car.getModel().forEach(model -> {
//                    model.getModel().remove(car);
//                });
//
//                // Now remove the superhero
//                entityManager.remove(car);
//
//                // Commit the transaction
//                entityManager.getTransaction().commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public CarRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public Car createCar(Car car) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(car);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return car;
//    }

}
