package service;
import configuration.JPAConfiguration;
import entity.CarDealership;
import repository.CarDealershipRepository;
import java.util.List;

public class CarDealershipService {
    private final CarDealershipRepository repository;

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

}
