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
public class Klant implements List<Klant> {

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

    public Klant(int id, String first_name, String last_name, String email) {
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

    public void setCars(List<Car> huur) {
        this.cars = huur;
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Klant> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Klant klant) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Klant> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Klant> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Klant get(int index) {
        return null;
    }

    @Override
    public Klant set(int index, Klant element) {
        return null;
    }

    @Override
    public void add(int index, Klant element) {

    }

    @Override
    public Klant remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Klant> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Klant> listIterator(int index) {
        return null;
    }

    @Override
    public List<Klant> subList(int fromIndex, int toIndex) {
        return null;
    }

}
