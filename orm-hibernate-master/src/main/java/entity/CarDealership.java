package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "CARDEALERSHIP" )

public class CarDealership {
    @Id
    @GeneratedValue
    private Integer Id;
    private String Name;
    private String Location;

    @ManyToMany(
            mappedBy = "carDealerships",
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    private Set<Car> car = new HashSet();
//    private Set<Klant> klant = new HashSet();

    public CarDealership() {
    }

    public CarDealership(Integer id, String name, String location) {
        this.Id = id;
        this.Name = name;
        this.Location = location;
    }

    public CarDealership(String name) {
        this.Name = name;
    }

//    public CarDealership(String location) {
//        this.Location = location;
//    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public Set<Car> getCar() {
        return this.car;
    }

    public void addCar(Car car) {
        this.car.add(car);
        car.getCar().add(this);
    }

    public String toString() {
        return "Cardealership{id=" + this.Id + ", name='" + this.Name + ", location='" + this.Location + "'}";
    }

}
