package entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Entity
public class Garage {

    @Id
    @GeneratedValue
    private int id;
    private String aantal;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

//    private Set<Car> cars = new HashSet();
//    private Set<Garage> garages;

    public Garage(int id, String aantal) {
    }

    public Garage(String aantal) {
        this.aantal = aantal;
    }

    public Garage() {
    }

    public int getId() { return id; }

    private void  setId(int id) { id = id; }

    public String getAantal() { return aantal; }

    public void setAantal(String aantal) { aantal = aantal; }

    public  Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

//    public Set<Garage> getGarages() {
//        return this.garages;
//    }

    public String toString() {
        return "Garage{id=" + this.id + "', aantal='" + this.aantal + "'}";
    }

}
