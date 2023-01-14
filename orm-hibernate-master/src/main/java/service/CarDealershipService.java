package service;
import configuration.JPAConfiguration;
import entity.CarDealership;
import repository.CarDealershipRepository;

public class CarDealershipService {
    private CarDealershipRepository carDealershipRepository;

    public CarDealershipService() {
        this.carDealershipRepository = new CarDealershipRepository(JPAConfiguration.getEntityManager());
    }

    public CarDealership createCarDealership(CarDealership carDealership){
        return carDealershipRepository.createCarDealership(carDealership);
    }

    public CarDealership updateCarDealership(CarDealership carDealership) {
        return carDealershipRepository.updateCardealership(carDealership);
    }

    public CarDealership deleteCarDealership(CarDealership carDealership) {
        return carDealershipRepository.deleteCardealership(carDealership);
    }

}
