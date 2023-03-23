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
public class Car {
    @Id
    @GeneratedValue
    private int Id;
    private String car_brand;
    private String model;
    @ManyToOne
    @JoinColumn(name = "klant_id")
    private Klant klant;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST}
    )
    @JoinTable(
            name = "Car_CarDealership",
            joinColumns = {@JoinColumn(
                    name = "car_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "carDealership_id"
            )}
    )
    private Set<CarDealership> carDealerships = new HashSet();


//    private Set<CarDealership> carDealerships = new HashSet();
//    private List<Klant> klants;

    public Car(int id, String car_brand, String model) {
    }

    public Car(String car_brand, String model) {
        this.car_brand = car_brand;
        this.model = model;
    }

    public Car() {
    }

//    public List<Klant> getKlants() {
//        return this.klants;
//    }
//
//    public void setKlants(List<Klant> klants) {
//        this.klants = klants;
//    }

    public int getId() { return Id; }

    private void  setId(int id) { Id = id; }

    public String getCar_brand() { return car_brand; }
    public void setCar_brand(String car_brand) { this.car_brand = car_brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Klant getPerson() { return klant; }

    public void setPerson(Klant klant) { this.klant = klant; }

    public Set<CarDealership> getCarDealerships() {
        return this.carDealerships;
    }

    public String toString() {
        return "Car{id=" + this.Id + ", car_brand='" + this.car_brand + "', model='" + this.model + "'}";
    }

    public void setCarId(KlantInfo detail) {
    }

}
