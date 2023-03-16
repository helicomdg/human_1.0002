package menu;

import entity.*;
import service.*;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        System.out.println("(0) dummy data");
        System.out.println("(1) order");
        System.out.println("(11) klant");
        System.out.println("(12) klant Info");
        System.out.println("(13) car");
        System.out.println("(14) garage");
        System.out.println("(15) car dealership");
        System.out.println("(99) Exit");
    }

    public static void menuInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Menu option> ");
        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "0" : Menu.dummyData();
            break;
            case "1" : Menu.Order();
            break;
            case "11" : Menu.Klant();
            break;
            case "12" : Menu.KlantInfo();
            break;
            case "13": Menu.Car();
            break;
            case "14": Menu.Garage();
            break;
            case "15": Menu.CarDealership();
            break;
            case "99": System.exit(0);
            break;
        }
    }

    private static void dummyData() {

        DummyDataService dummyDataService = new DummyDataService();
        dummyDataService.createDummyData();
    }

    private static void Order() {

        KlantService klantService = new KlantService();
        KlantInfoService klantInfoService = new KlantInfoService();
        CarService carService = new CarService();
        CarDealershipService carDealershipService = new CarDealershipService();
        Scanner s = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Order list:");
            System.out.println("1.Order");
            System.out.println("2.Display");
//            System.out.println("3.SEARCH");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            switch (ch) {
                case 1:
                    System.out.print("Enter first_name : ");
                    String first_name = s.next();
                    System.out.print("Enter last_name : ");
                    String last_name = s.next();
                    System.out.print("Enter email : ");
                    String email = s.next();
                    System.out.print("Enter adress : ");
                    String adress = s.next();
                    System.out.print("Enter bank : ");
                    String bank = s.next();
                    System.out.print("Enter geboorteDatum : ");
                    String geboorteDatum = s.nextLine();
                    System.out.print("Enter car brand : ");
                    String car_brand = s.next();
                    System.out.print("Enter car model : ");
                    String model = s.next();
                    System.out.print("Enter dealership name brand : ");
                    String name = s.next();
                    System.out.print("Enter dealership location model : ");
                    String location = s.next();
                    klantService.createKlant(new Klant(first_name, last_name, email));
                    klantInfoService.createKlantInfo(new KlantInfo(adress, bank, geboorteDatum));
                    carService.createCar(new Car(car_brand, model));
                    carDealershipService.createCarDealership(new CarDealership(name, location));
                    break;

                case 2:
                      System.out.println("_______________________");
                    List<Klant> klanten = klantService.getKlanten();
                    List<KlantInfo> Info = klantInfoService.getInfo();
                    List<Car> cars = carService.getCars();
                    List<CarDealership> dealerships = carDealershipService.getDealerships();
                    for (Klant klant : klanten) {
                        System.out.println("ID= " + klant.getId() + "  First_name= " + klant.getFirst_name() + "  Last_name= " + klant.getLast_name() + "  Email= " + klant.getEmail());
                    }
                    for (KlantInfo klantInfo : Info) {
                        System.out.println("ID= " + klantInfo.getId() + "  adress= " + klantInfo.getAdress() + "  bank= " + klantInfo.getBank() + "  geboorteDatum= " + klantInfo.getGeboorteDatum());
                    }
                    for (Car car : cars) {
                        System.out.println("ID= " + car.getId() + "  car brand= " + car.getCar_brand() + "  model= " + car.getModel());
                    }
                    for (CarDealership carDealership : dealerships) {
                        System.out.println("ID= " + carDealership.getId() + "  Shop= " + carDealership.getName() + "  location= " + carDealership.getLocation());
                    }
                    System.out.println("_______________________");
                    break;
//
//                case 3:
//                    found = false;
//                    System.out.println("Enter first_name to Search:");
//                    first_name = s.next();
//                    System.out.println("_______________________");
//                    klanten = klantService.getKlanten();
//                    for (Klant klant : klanten) {
//                        if (klant.getFirst_name().equals(first_name)) {
//                            System.out.println(klant);
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Record Not Found");
//                    }
//                    System.out.println("_______________________");
//                    break;

                case 9:
                    Menu.menuInput();
            }
        } while (ch != 0);
    }

    public static void Klant() {

        KlantService klantService = new KlantService();
        KlantInfoService klantInfoService = new KlantInfoService();
        Scanner s = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Klanten list:");
            System.out.println("1.CREATE");
            System.out.println("2.Display");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            switch (ch) {
                case 1:
                    System.out.print("Enter first_name : ");
                    String first_name = s.next();
                    System.out.print("Enter last_name : ");
                    String last_name = s.next();
                    System.out.print("Enter email : ");
                    String email = s.next();
                    System.out.print("Enter adress : ");
                    String adress = s.next();
                    System.out.print("Enter bank : ");
                    String bank = s.next();
                    System.out.print("Enter geboorteDatum : ");
                    String geboorteDatum = s.next();
                    klantService.createKlant(new Klant(first_name, last_name, email));
                    klantInfoService.createKlantInfo(new KlantInfo(adress, bank, geboorteDatum));
                    break;

                case 2:
                    System.out.println("_______________________");
                    List<Klant> klanten = klantService.getKlanten();
                    List<KlantInfo> Info = klantInfoService.getInfo();
                    for (Klant klant : klanten) {
                        System.out.println("ID= " + klant.getId() + "  First_name= " + klant.getFirst_name() + "  Last_name= " + klant.getLast_name() + "  Email= " + klant.getEmail());
                    }
                    for (KlantInfo klantInfo : Info) {
                        System.out.println("ID= " + klantInfo.getId() + "  adress= " + klantInfo.getAdress() + "  bank= " + klantInfo.getBank() + "  geboorteDatum= " + klantInfo.getGeboorteDatum());
                    }
                    System.out.println("_______________________");
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter first_name to Search:");
                    first_name = s.next();
                    System.out.println("_______________________");
                    klanten = klantService.getKlanten();
                    for (Klant klant : klanten) {
                        if (klant.getFirst_name().equals(first_name)) {
                            System.out.println(klant);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("_______________________");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter First_name to Delete:");
                    first_name = s.next();
                    System.out.println("_______________________");
                    List<Klant> opgehaaldeKlanten = klantService.getKlanten();
                    for (Klant klant : opgehaaldeKlanten) {
                        if (klant.getFirst_name().equals(first_name)) {
                            klantService.deleteKlant(klant);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Deleted");
                    }
                    System.out.println("_______________________");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter name to Update:");
                    first_name = s.next();
                    System.out.print("Enter New first_name:");
                    String updateFirst_name = s.next();
                    System.out.print("Enter New last_name:");
                    String updateLast_name = s.next();
                    System.out.print("Enter New email:");
                    String updateEmail = s.next();
                    List<Klant> listUpdateKlanten = klantService.getKlanten();
                    for (Klant klant : listUpdateKlanten) {
                        if (klant.getFirst_name().equalsIgnoreCase(first_name)) {
                            klant.setFirst_name(updateFirst_name);
                            klant.setLast_name(updateLast_name);
                            klant.setEmail(updateEmail);
                            klantService.updateKlant(klant);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Updated");
                    }
                    break;
                case 9:
                    Menu.menuInput();
            }
        } while (ch != 0);
    }

    public static void KlantInfo() {

        KlantInfoService klantInfoService = new KlantInfoService();
        Scanner s = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Klant Info list:");
            System.out.println("1.Display");
            System.out.println("2.SEARCH");
            System.out.println("3.DELETE");
//            System.out.println("4.UPDATE");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            String first_name;
            switch (ch) {
                case 1:
                    System.out.println("_______________________");
                    List<KlantInfo> Info = klantInfoService.getInfo();
                    for (KlantInfo klantInfo : Info) {
                        System.out.println("ID= " + klantInfo.getId() + "  adress= " + klantInfo.getAdress() + "  bank= " + klantInfo.getBank() + "  geboorteDatum= " + klantInfo.getGeboorteDatum());
                    }
                    System.out.println("_______________________");
                    break;

                case 2:
                    found = false;
                    System.out.println("Enter ID to Search:");
                    Long id = s.nextLong();
                    System.out.println("_______________________");
                    Info = klantInfoService.getInfo();
                    for (KlantInfo klantInfo : Info) {
                        if (klantInfo.getId().equals(id)) {
                            System.out.println(klantInfo);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("_______________________");
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter Id to Delete:");
                    id = s.nextLong();
                    System.out.println("_______________________");
                    List<KlantInfo> opgehaaldeInfo = klantInfoService.getInfo();
                    for (KlantInfo klantInfo : opgehaaldeInfo) {
                        if (klantInfo.getId().equals(id)) {
                            klantInfoService.deleteKlantInfo(klantInfo);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Deleted");
                    }
                    System.out.println("_______________________");
                    break;

//                case 4:
//                    found = false;
//                    System.out.println("Enter Id to Update:");
//                    id = s.nextLong();
//                    System.out.print("Enter New adress:");
//                    String updateAdress = s.next();
//                    System.out.print("Enter New bank:");
//                    String updateBank = s.next();
//                    System.out.print("Enter New geboorte datum:");
//                    String updateGeboorteDatum = s.next();
//                    List<KlantInfo> listUpdateInfo = klantInfoService.getInfo();
//                    for (KlantInfo klantInfo : listUpdateInfo) {
//                        if (klantInfo.getId().equalsIgnoreCase(id)) {
//                            klantInfo.setAdress(updateAdress);
//                            klantInfo.setBank(updateBank);
//                            klantInfo.setGeboorteDatum(updateGeboorteDatum);
//                            klantInfoService.updateKlantInfo(klantInfo);
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Record Not Found");
//                    } else {
//                        System.out.println("Record Updated");
//                    }
//                    break;
                case 9:
                    Menu.menuInput();
            }
        } while (ch != 0);
    }

    public static void Car() {

        CarService carService = new CarService();
        GarageService garageService = new GarageService();
        Scanner s = new Scanner(System.in);

        int ch;
        do {
            System.out.println("Car list:");
            System.out.println("1.CREATE");
            System.out.println("2.Display");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            switch (ch) {
                case 1:
                    System.out.print("Enter car_brand : ");
                    String car_brand = s.nextLine();
                    System.out.print("Enter model : ");
                    String model = s.nextLine();
                    System.out.print("Enter aantal : ");
                    String aantal = s.nextLine();
                    carService.createCar(new Car(car_brand, model));
                    garageService.createGarage(new Garage(aantal).getCar());
                    break;

                case 2:
                    System.out.println("_______________________");
                    List<Car> cars = carService.getCars();
                    List<Garage> garages = garageService.getGarages();
                    for (Car car : cars) {
                        System.out.println("ID= " + car.getId() + "  car_brand= " + car.getCar_brand() + "  model= " + car.getModel());
                    }
                    for (Garage garage : garages) {
                        System.out.println("ID= " + garage.getId() + "  aantal= " + garage.getAantal());
                    }
                    System.out.println("_______________________");
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter car_brand to Search:");
                    car_brand = s.next();
                    System.out.println("_______________________");
                    cars = carService.getCars();
                    for (Car car : cars) {
                        if (car.getCar_brand().equals(car_brand)) {
                            System.out.println(car);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("_______________________");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter Car_brand to Delete:");
                    car_brand = s.next();
                    System.out.println("_______________________");
                    List<Car> opgehaaldeCars = carService.getCars();
                    for (Car car : opgehaaldeCars) {
                        if (car.getCar_brand().equals(car_brand)) {
                            carService.deleteCar(car);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Deleted");
                    }
                    System.out.println("_______________________");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter brand to Update:");
                    car_brand = s.next();
                    System.out.print("Enter New car_brand:");
                    String updateCar_brand = s.next();
                    System.out.print("Enter New model:");
                    String updateModel = s.next();
                    List<Car> listUpdateCars = carService.getCars();
                    for (Car car : listUpdateCars) {
                        if (car.getCar_brand().equalsIgnoreCase(car_brand)) {
                            car.setCar_brand(updateCar_brand);
                            car.setModel(updateModel);
                            carService.updateCar(car);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Updated");
                    }
                    break;
                case 9:
                    Menu.menuInput();
            }
        } while (ch != 0);
    }

    public static void Garage() {

        CarService carService = new CarService();
        GarageService garageService = new GarageService();
        Scanner s = new Scanner(System.in);

        int ch;
        do {
            System.out.println("Car list:");
            System.out.println("1.Display");
//            System.out.println("2.SEARCH");
//            System.out.println("3.DELETE");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            List<Garage> garages;
            String car_brand;
            switch (ch) {
                case 1:
                    System.out.println("_______________________");
                    garages = garageService.getGarages();
                    for (Garage garage : garages) {
                        System.out.println("ID= " + garage.getId() + "  aantal= " + garage.getAantal());
                    }
                    System.out.println("_______________________");
                    break;

//                case 2:
//                    found = false;
//                    System.out.println("Enter id to Search:");
//                    Long id = s.nextLong();
//                    System.out.println("_______________________");
//                    garages = garageService.getGarages();
//                    for (Garage garage : garages) {
//                        if (garage.getId().equals(id)) {
//                            System.out.println(garage);
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Record Not Found");
//                    }
//                    System.out.println("_______________________");
//                    break;
//
//                case 3:
//                    found = false;
//                    System.out.println("Enter id to Delete:");
//                    id = s.nextLong();
//                    System.out.println("_______________________");
//                    List<Garage> opgehaaldeGarages = garageService.getGarages();
//                    for (Garage garage : opgehaaldeGarages) {
//                        if (garage.getId().equals(id)) {
//                            carService.deleteCar(garage);
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Record Not Found");
//                    } else {
//                        System.out.println("Record Deleted");
//                    }
//                    System.out.println("_______________________");
//                    break;
                case 9:
                    Menu.menuInput();
            }
        } while (ch != 0);
    }

    public static void CarDealership() {

        CarDealershipService carDealershipService = new CarDealershipService();
        Scanner s = new Scanner(System.in);

        int ch;
        do {
            System.out.println("Dealership list:");
            System.out.println("1.CREATE");
            System.out.println("2.Display");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("9.exit");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            switch (ch) {
                case 1:
                    System.out.print("Enter name : ");
                    String name = s.nextLine();
                    System.out.print("Enter location : ");
                    String location = s.nextLine();
                    carDealershipService.createCarDealership(new CarDealership(location, name));
                    break;

                case 2:
                    System.out.println("_______________________");
                    List<CarDealership> dealerships = carDealershipService.getDealerships();
                    for (CarDealership carDealership : dealerships) {
                        System.out.println("ID= " + carDealership.getId() + "  name= " + carDealership.getName() + "  Location= " + carDealership.getLocation());
                    }
                    System.out.println("_______________________");
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter name to Search:");
                    name = s.next();
                    System.out.println("_______________________");
                    dealerships = carDealershipService.getDealerships();
                    for (CarDealership carDealership : dealerships) {
                        if (carDealership.getName().equals(name)) {
                            System.out.println(carDealership);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("_______________________");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter name to Delete:");
                    name = s.next();
                    System.out.println("_______________________");
                    List<CarDealership> opgehaaldeDealership = carDealershipService.getDealerships();
                    for (CarDealership carDealership : opgehaaldeDealership) {
                        if (carDealership.getName().equals(name)) {
                            carDealershipService.deleteCarDealership(carDealership);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Deleted");
                    }
                    System.out.println("_______________________");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter name to Update:");
                    name = s.next();
                    System.out.print("Enter New name:");
                    String updateName = s.next();
                    System.out.print("Enter New location:");
                    String updateLocation = s.next();
                    List<CarDealership> listUpdateDealerships = carDealershipService.getDealerships();
                    for (CarDealership carDealership : listUpdateDealerships) {
                        if (carDealership.getName().equalsIgnoreCase(name)) {
                            carDealership.setName(updateName);
                            carDealership.setLocation(updateLocation);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record Updated");
                    }
                    break;
                case 9:
                    Menu.menuInput(); 
            }
        } while (ch != 0);
    }
}
