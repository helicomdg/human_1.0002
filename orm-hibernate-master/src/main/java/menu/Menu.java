package menu;

import entity.Klant;
import service.DummyDataService;
import service.KlantService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void Klant(){

        DummyDataService dummyDataService = new DummyDataService();
        dummyDataService.createDummyData();

        KlantService klantService = new KlantService();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        int ch;
        do {
            System.out.println("Klanten list:");
            System.out.println("1.CREATE");
            System.out.println("2.Display");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("69.EXIT");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            boolean found = false;
            List<Klant> klanten;
            String first_name;
            switch (ch) {
                case 1:
                    System.out.print("Enter first_name : ");
                    first_name = s1.nextLine();
                    System.out.print("Enter last_name : ");
                    String last_name = s1.nextLine();
                    System.out.print("Enter email : ");
                    String email = s1.nextLine();
                    klantService.createKlant(new Klant(first_name, last_name, email));
                    break;

                case 2:
                    System.out.println("_______________________");
                    klanten = klantService.getKlanten();
                    for (Klant klant : klanten) {
                        System.out.println("ID= " + klant.getId() + "  First_name= " + klant.getFirst_name() + "  Last_name= " + klant.getLast_name() + "  Email= " + klant.getEmail());
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

                case 69: System.exit(0);
            }
        }while(ch!=0);
    }

}
