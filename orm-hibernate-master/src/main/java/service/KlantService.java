package service;

import configuration.JPAConfiguration;
import entity.Klant;
import repository.KlantRepository;

import java.util.*;

public class KlantService {

    private final KlantRepository repository;

    public KlantService() {
        this.repository = new KlantRepository(JPAConfiguration.getEntityManager());
    }

    public List<Klant> getKlant() {
        return repository.getKlant();
    }

    public Klant createKlant(Klant klant) {
        return repository.createKlant(klant);
    }
//
//    public Klant updateKlant(Klant klant) { return repository.updateKlant(klant);}
//
//    public Klant deleteKlant(Klant klant) { return repository.deleteKlant(klant);}

    /*public static void main(String[] args){

        List<Klant> c = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        int ch;
        do{
            System.out.println("1.CREATE");
            System.out.println("2.Display");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();

            switch(ch){
                case 1:
                    System.out.print("Enter id : ");
                    int id  = s.nextInt();
                    System.out.print("Enter first_name : ");
                    String first_name  = s1.nextLine();
                    System.out.print("Enter last_name : ");
                    String last_name  = s1.nextLine();
                    System.out.print("Enter email : ");
                    String email  = s1.nextLine();
                    System.out.print("Enter klant_info : ");
                    String klant_info  = s1.nextLine();

                    c.add(new Klant(id, first_name, last_name, email, klant_info));
                break;

                case 2:
                    System.out.println("_______________________");
                    Iterator<Klant> i = c.iterator();
                    while (i.hasNext()){
                        Klant k =i.next();
                        System.out.println(k);
                    }
                    System.out.println("_______________________");
                break;

                case 3:
                    boolean found = false;
                    System.out.println("Enter id to Search:");
                    id = s.nextInt();
                    System.out.println("_______________________");
                    i = c.iterator();
                    while (i.hasNext()){
                        Klant k =i.next();
                        if(k.getId() == id) {
                        System.out.println(k);
                        found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    System.out.println("_______________________");
                break;

                case 4:
                    found = false;
                    System.out.println("Enter id to Delete:");
                    id = s.nextInt();
                    System.out.println("_______________________");
                    i = c.iterator();
                    while (i.hasNext()){
                        Klant k =i.next();
                        if(k.getId() == id) {
                            i.remove();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    else{
                        System.out.println("Record Deleted");
                    }
                    System.out.println("_______________________");
                break;

                case 5:
                    found = false;
                    System.out.println("Enter id to Update:");
                    id = s.nextInt();
                    ListIterator<Klant>li = c.listIterator();
                    while (li.hasNext()){
                        Klant k =li.next();
                        if(k.getId() == id) {
                            System.out.print("Enter New first_name:");
                            first_name = s1.nextLine();
                            System.out.print("Enter New last_name:");
                            last_name = s1.nextLine();
                            System.out.print("Enter New email:");
                            email = s1.nextLine();
                            System.out.print("Enter New klant_info:");
                            klant_info = s1.nextLine();
                            li.set(new Klant(id, first_name, last_name, email, klant_info));
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    else{
                        System.out.println("Record Updated");
                    }
                break;
            }
        }while(ch!=0);
    }
*/
}
