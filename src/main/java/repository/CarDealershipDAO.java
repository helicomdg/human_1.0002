package repository;

import entity.Car;
import entity.CarDealership;

public interface CarDealershipDAO {
    public void addCarDealership(CarDealership carDealership);
    public void updateCarDealership(CarDealership carDealership);
    public void deleteCarDealershipById(int id);
    public Car getCarById(int id);
}
