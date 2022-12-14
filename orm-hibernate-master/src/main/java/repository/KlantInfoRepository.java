package repository;

import entity.KlantInfo;
import jakarta.persistence.EntityManager;

public class KlantInfoRepository {

    private EntityManager entityManager;

    public KlantInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public KlantInfo createKlantInfo(KlantInfo klantInfo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(klantInfo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return klantInfo;
    }

//    public KlantInfo deleteKlantInfo(KlantInfo klantInfo){
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.find(KlantInfo.class, klantInfo.getId());
//            if(klantInfo != null)  entityManager.remove(klantInfo);
//            entityManager.getTransaction().commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return klantInfo;
//    }
//
//
//    public KlantInfo updateKlantInfo(KlantInfo klantInfo){
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.find(KlantInfo.class, klantInfo.getId());
//            entityManager.merge(klantInfo);
//            entityManager.getTransaction().commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return klantInfo;
//    }
}
