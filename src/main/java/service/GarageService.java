package service;
import configuration.JPAConfiguration;
import entity.Car;
import entity.Garage;
import entity.Klant;
import repository.GarageRepository;

import java.util.List;

public class GarageService {
    private final GarageRepository repository;

    public GarageService() {
        this.repository = new GarageRepository(JPAConfiguration.getEntityManager());
    }

    public List<Garage> getGarages() {
        return repository.getGarage();
    }
    public Car createGarage(Car garage){
        return repository.createGarage(garage);
    }

    public Garage updateGarage(Garage garage) {
        return repository.updateGarage(garage);
    }

    public Garage deleteGarage(Garage garage) {
        return repository.deleteGarage(garage);
    }

}
