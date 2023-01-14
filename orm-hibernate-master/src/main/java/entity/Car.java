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
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    private int Id;
    private String Car_brand;
    private String Model;
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
    public Car() {
    }

    public int getId() { return Id; }

    private void  setId(int id) { Id = id; }

    public String getCar_brand() { return Car_brand; }
    public void setCar_brand(String car_brand) { Car_brand = car_brand; }

    public String getModel() { return Model; }
    public void setModel(String model) { Model = model; }

    public Klant getPerson() { return klant; }

    public void setPerson(Klant klant) { this.klant = klant; }
    public <E> List getCar() {
        return null;
    }

    public Set<CarDealership> getCarDealerships() {
        return this.carDealerships;
    }

    public String toString() {
        return "Car{id=" + this.Id + ", car_brand='" + this.Car_brand + "', model='" + this.Model + "'}";
    }

    public void setCarId(KlantInfo detail) {
    }

}
