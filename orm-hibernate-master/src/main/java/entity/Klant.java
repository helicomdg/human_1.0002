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
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klant {

    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String klant_info;

    @OneToOne
    private KlantInfo klantInfoId;

    //verander variable naam naar "cars"
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "klant_id" )
    private List<Car> huur = new ArrayList();

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

    public Klant(int id, String first_name, String last_name, String email) {
    }

    public Klant(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public Klant() {
    }

    public List<Car> getHuur() {
        return this.huur;
    }

    public void setHuur(List<Car> huur) {
        this.huur = huur;
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

    public String getKlant_info() {
        return this.klant_info;
    }

    public void setKlant_info(String klant_info) {
        this.klant_info = klant_info;
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
//        Long var10000 = this.id;
        return "Klant{id=" + this.id + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', email='" + this.email + "', klant_info='" + this.klant_info + "'}";
    }

}
