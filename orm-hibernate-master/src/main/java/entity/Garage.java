package entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;

@Entity
public class Garage {
    @Id
    @GeneratedValue
    private int id;
    private String aantal;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public int getId() { return id; }

    private void  setId(int id) { id = id; }

    public String getAantal() { return aantal; }

    public void setAantal(String aantal) { aantal = aantal; }

    public  Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

}
