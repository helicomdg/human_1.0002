package service;

import configuration.JPAConfiguration;
import entity.Klant;
import entity.KlantInfo;
import repository.KlantInfoRepository;

import java.util.List;

public class KlantInfoService {

    private final KlantInfoRepository repository;
    private KlantInfoService klantInfoDao;

    public KlantInfoService() {
        this.repository = new KlantInfoRepository(JPAConfiguration.getEntityManager());
    }

    public List<KlantInfo> getInfo() {
        return repository.getInfo();
    }

    public KlantInfo createKlantInfo(KlantInfo klantInfo){
        return repository.createKlantInfo(klantInfo);
    }

    public KlantInfo updateKlantInfo(KlantInfo klantInfo) {
        return repository.updateKlantInfo(klantInfo);
    }

    public KlantInfo deleteKlantInfo(KlantInfo klantInfo) {
        return repository.deleteKlantInfo(klantInfo);
    }

    public KlantInfo getKlantInfoById(Long id) {
        return klantInfoDao.getKlantInfoById(id);
    }

    public KlantInfo addKlantInfo(KlantInfo klantInfo) {
        klantInfoDao.addKlantInfo(klantInfo);
        return klantInfo;
    }

    public KlantInfo updateKlantInfo1(Long id, KlantInfo klantInfo) {
        klantInfoDao.updateKlantInfo(klantInfo);
        return klantInfo;
    }

    public boolean deleteKlantInfoById(Long id) {
        klantInfoDao.deleteKlantInfoById(id);
        return false;
    }

}
