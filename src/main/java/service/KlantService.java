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

    public Klant createKlant1(String first_name, String last_name, String email) {
        return repository.createKlant1(first_name, last_name, email);
    }

    public static Klant updateKlant1(Long id, Klant klant) {
        klantDao.updateKlant(klant);
        return klant;
    }
    public Klant updateKlant1(Long id, String first_name, String last_name, String email){
        return repository.updateKlant1(id, first_name, last_name, email);
    }
    public Klant updateEmail(Long id, String email) {
        return repository.updateEmail(id, email);
    }
    public Klant updateName(Long id,  String first_name, String last_name) {
        return repository.updateName(id, first_name, last_name);
    }

    public void removeKlant(Long id) {
        klantDao.removeKlant(id);
    }

    public Klant findKlantByid(Long id) {
        return repository.findKlantByid(id);
    }

    public void deleteKlant1(Long id) {
        repository.deleteKlant1(id);
    }

}
