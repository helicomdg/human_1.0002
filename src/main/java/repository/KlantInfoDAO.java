package repository;

import entity.Klant;
import entity.KlantInfo;

public interface KlantInfoDAO {
    public void addKlantInfo(KlantInfo klantInfo);
    public void updateKlantInfo(KlantInfo klantInfo);
    public void deleteKlantInfoById(Long id);
    public Klant getKlantInfoById(Long id);
}
