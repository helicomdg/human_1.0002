package service;

import configuration.JPAConfiguration;
import entity.KlantInfo;
import repository.KlantInfoRepository;

public class KlantInfoService {

    private KlantInfoRepository klantInfoRepository;

    public KlantInfoService() {
        this.klantInfoRepository = new KlantInfoRepository(JPAConfiguration.getEntityManager());
    }

    public KlantInfo createKlantInfo(KlantInfo klantInfo){
        return klantInfoRepository.createKlantInfo(klantInfo);
    }

    public KlantInfo updateKlantInfo(KlantInfo klantInfo) {
        return klantInfoRepository.updateKlantInfo(klantInfo);
    }

    public KlantInfo deleteKlantInfo(KlantInfo klantInfo) {
        return klantInfoRepository.deleteKlantInfo(klantInfo);
    }

}
