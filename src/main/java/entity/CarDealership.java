package entity;
import jakarta.persistence.*;

@Entity
public class CarDealership {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private String location;

//    @ManyToMany(
//            cascade = {CascadeType.PERSIST},
//            fetch = FetchType.EAGER
//    )
//    @JoinTable(
//            name = "CarDealership_Klant",
//            joinColumns = {@JoinColumn(
//                    name = "carDealership_id"
//            )},
//            inverseJoinColumns = {@JoinColumn(
//                    name = "klant_id"
//            )}
//    )

//    private Set<Car> cars = new HashSet();

//    private List<Klant> klanten;



    public CarDealership(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public CarDealership() {
    }
//    private List<Klant> getKlanten() { return this.klanten; }
//    public void setKlanten(List<Klant> klanten) {
//        this.klanten = klanten;
//    }


    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public Set<Car> getCars() {
//        return this.cars;
//    }

    public String toString() {
        return "Cardealership{id=" + this.Id + ", name='" + this.name + ", location='" + this.location + "'}";
    }

}
