package entity;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class KlantInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String adress;
    private String bank;
    private String geboorteDatum;

    public KlantInfo(int id, String adress, String bank, String geboorteDatum) {
    }

    public KlantInfo(String adress, String bank, String geboorteDatum) {
        this.adress = adress;
        this.bank = bank;
        this.geboorteDatum = geboorteDatum;
    }

    public KlantInfo() {
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bankNaam) {
        this.bank = bankNaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }


    public String toString() {
        return "Klant Info{id=" + this.id + "', bank='" + this.bank + "', adress='" + this.adress + "', geboortedata='" + this.geboorteDatum + "'}";
    }
}
