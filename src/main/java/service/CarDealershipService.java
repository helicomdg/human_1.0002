package service;
import configuration.JPAConfiguration;
import entity.Car;
import entity.CarDealership;
import entity.Klant;
import repository.CarDealershipRepository;
import java.util.List;

public class CarDealershipService {
    private final CarDealershipRepository repository;
    private CarDealershipService carDealershipDao;

    public CarDealershipService() {
        this.repository = new CarDealershipRepository(JPAConfiguration.getEntityManager());
    }

    public List<CarDealership> getDealerships() {
        return repository.getDealerships();
    }

    public CarDealership createCarDealership(CarDealership carDealership){
        return repository.createCarDealership(carDealership);
    }

    public CarDealership updateCarDealership(CarDealership carDealership) {
        return repository.updateCardealership(carDealership);
    }
    public CarDealership deleteCarDealership(CarDealership carDealership) {
        return repository.deleteCardealership(carDealership);
    }
    public CarDealership getCarDealership(int id) {
        return repository.getCarDealership(id);
    }
    public CarDealership findCarDealershipByid(int id) {
        return repository.findCarDealershipByid(id);
    }
    public CarDealership getCarDealershipById(int id) {
        return carDealershipDao.getCarDealershipById(id);
    }
    public CarDealership addCarDealership(CarDealership carDealership) {
        carDealershipDao.addCarDealership(carDealership);
        return carDealership;
    }
    public CarDealership updateCarDealership1(int id, CarDealership carDealership) {
        carDealershipDao.updateCarDealership(carDealership);
        return carDealership;
    }
    public boolean deleteCarDealershipById(int id) {
        carDealershipDao.deleteCarDealershipById(id);
        return false;
    }

}
