package service;

import entity.Car;
import entity.Garage;
import entity.Klant;
import entity.KlantInfo;

public class DummyDataService {

    private final KlantService klantService;
    private final KlantInfoService klantInfoService;
    private final CarService carService;
    private final GarageService garageService;

    public DummyDataService() {
        this.klantService = new KlantService();
        this.klantInfoService = new KlantInfoService();
        this.carService = new CarService();
        this.garageService =  new GarageService();
    }

    public void createDummyData(){
        KlantService klantService = new KlantService();
        KlantInfoService klantInfoService = new KlantInfoService();
        CarService carService = new CarService();
        GarageService garageService = new GarageService();

        KlantInfo klantInfo = new KlantInfo();
        klantInfo.setAdress("Elisabethshof #3");
        klantInfo.setBank("DSB");
        klantInfo.setGeboorteDatum("12-12-1992");

        KlantInfo detail = klantInfoService.createKlantInfo(klantInfo);

        Klant createKlant = new Klant();
        createKlant.setFirst_name("Shaq");
        createKlant.setLast_name("O'Neil");
        createKlant.setEmail("soneil@unasat.sr");
        createKlant.setKlantInfoId(detail);

        klantService.createKlant(createKlant);

        Car createCar = new Car();
        createCar.setCar_brand("Toyota");
        createCar.setModel("Starlet");
        createKlant.setKlantInfoId(detail);

        carService.createCar(createCar);

        Garage garage = new Garage();
        garage.setAantal("7");
        createCar.setCarId(detail);

        garageService.createGarage(createCar);
    }

}
