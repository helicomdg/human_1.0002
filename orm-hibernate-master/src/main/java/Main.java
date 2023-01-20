import entity.Klant;

import menu.Menu;
import service.KlantService;
public class Main {

    public static void main(String[] args) {

        KlantService klantService = new KlantService();

        while (true){
            Menu.Klant();
//            Menu.KlantInfo();
//            Menu.Car();
//            Menu.Garage();
//            Menu.CarDealership();
        }
    }

}