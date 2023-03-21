package repository;

import entity.Klant;
import java.util.List;

public interface KlantDAO {
    public void addKlant(Klant klant);
    public void updateKlant(Klant klant);
    void removeKlant(Long id);
    public Klant getKlantById(Long id);
}
