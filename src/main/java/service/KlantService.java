package service;
import configuration.JPAConfiguration;
import entity.Klant;
import repository.KlantDAO;
import repository.KlantRepository;
import java.util.*;

public class KlantService {
    private final KlantRepository repository;
    private static KlantDAO klantDao;

    public KlantService() {
        this.repository = new KlantRepository(JPAConfiguration.getEntityManager());
    }
    public List<Klant> getKlanten() {
        return repository.getKlanten();
    }
    public Klant createKlant(Klant klant) {
        return repository.createKlant(klant);
    }
    public Klant updateKlant(Klant klant) {
        return repository.updateKlant(klant);
    }
    public Klant deleteKlant(Klant klant) {
        return repository.deleteKlant(klant);
    }

    public Klant getKlant(Long id) {
        return repository.getKlant(id);
    }


    public Klant getKlantById(Long id) {
        return klantDao.getKlantById(id);
    }

    public Klant addKlant(Klant klant) {
        klantDao.addKlant(klant);
        return klant;
    }

    public static Klant updateKlant1(Long id, Klant klant) {
        klantDao.updateKlant(klant);
        return klant;
    }

    public void removeKlant(Long id) {
        klantDao.removeKlant(id);
    }

}
