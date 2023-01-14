package service;
import configuration.JPAConfiguration;
import entity.Car;
import entity.Garage;
import repository.GarageRepository;

public class GarageService {
    private GarageRepository garageRepository;

    public GarageService() {
        this.garageRepository = new GarageRepository(JPAConfiguration.getEntityManager());
    }

    public Car createGarage(Car garage){
        return garageRepository.createGarage(garage);
    }

    public Garage updateGarage(Garage garage) {
        return garageRepository.updateGarage(garage);
    }

    public Garage deleteGarage(Garage garage) {
        return garageRepository.deleteGarage(garage);
    }

}
