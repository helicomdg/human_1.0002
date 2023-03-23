package service;

import configuration.JPAConfiguration;
import entity.Car;
import entity.Car;
import entity.Klant;
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
    public Car getCar(int id) {
        return repository.getCar(id);
    }
    public Car findCarByid(int id) {
        return repository.findCarByid(id);
    }


}
