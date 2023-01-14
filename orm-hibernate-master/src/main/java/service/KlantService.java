package service;
import configuration.JPAConfiguration;
import entity.Klant;
import repository.KlantRepository;
import java.util.*;

public class KlantService {

    private final KlantRepository repository;

    public KlantService() {
        this.repository = new KlantRepository(JPAConfiguration.getEntityManager());
    }

    public List<Klant> getKlanten() {
        return repository.getKlanten();
    }

    public Klant createKlant(Klant klant) {
        return repository.createKlant(klant);
    }

    public Klant updateKlant(Klant klant) { return repository.updateKlant(klant);}

    public Klant deleteKlant(Klant klant) { return repository.deleteKlant(klant);}

}
