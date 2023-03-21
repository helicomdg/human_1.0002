package repository;

import entity.Car;
import entity.Klant;

public interface CarDAO {
    public void addCar(Car car);
    public void updateCar(Car car);
    public void deleteCarById(int id);
    public Car getCarById(int id);
}
