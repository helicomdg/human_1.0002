package service;

import configuration.JPAConfiguration;
import entity.Car;
import repository.CarRepository;
import java.util.List;
import java.util.Optional;
public class CarService {

    private final CarRepository repository;

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
}
