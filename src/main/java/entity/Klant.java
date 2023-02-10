package entity;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.*;

@Entity
public class Klant {

    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private String email;

    @OneToOne
    private KlantInfo klantInfoId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "klant_id" )
    private List<Car> cars = new ArrayList();

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST}
    )
    @JoinTable(
            name = "Klant_CarDealership",
            joinColumns = {@JoinColumn(
                    name = "klant_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "carDealership_id"
            )}
    )
    private Set<CarDealership> carDealerships = new HashSet();

    public Klant(String first_name, String last_name) {
    }

    public Klant(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Klant() {
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public KlantInfo getKlantInfoId() {
        return this.klantInfoId;
    }

    public void setKlantInfoId(KlantInfo klantInfoId) {
        this.klantInfoId = klantInfoId;
    }

    public Set<CarDealership> getCarDealerships() {
        return this.carDealerships;
    }

    public String toString() {
        return "Klant{id=" + this.id + "', first_name='" + this.first_name + "', last_name='" + this.last_name + "', email='" + this.email + "'}";
    }
}
