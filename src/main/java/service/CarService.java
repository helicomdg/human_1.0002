package service;

import configuration.JPAConfiguration;
import entity.Car;
import entity.Car;
import repository.CarRepository;
import java.util.List;
import java.util.Optional;
public class CarService {

    private final CarRepository repository;
    private CarService carDao;

    public CarService() {
        this.repository = new CarRepository(JPAConfiguration.getEntityManager());
    }

    public List<Car> getCars() {
        return repository.getCars();
    }

    public Car createCar(Car car) {
        return repository.createCar(car);
    }

    public Car  updateCar(Car car) {
        return repository.updateCar(car);
    }

    public Car deleteCar(Car car) {
        return repository.deleteCar(car);
    }

    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    public Car addCar(Car car) {
        carDao.addCar(car);
        return car;
    }

    public Car updateCar1(Long id, Car car) {
        carDao.updateCar(car);
        return car;
    }

    public boolean deleteCarById(Long id) {
        carDao.deleteCarById(id);
        return false;
    }
}
