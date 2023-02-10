package repository;
import entity.KlantInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class KlantInfoRepository {

    private EntityManager entityManager;
    private List<KlantInfo> info;

    public KlantInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<KlantInfo> getInfo() {
        String query = "select i from KlantInfo i";
        TypedQuery<KlantInfo> typedQuery = entityManager.createQuery(query, KlantInfo.class);
        List<KlantInfo> info = typedQuery.getResultList();
        return info;
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

    public KlantInfo deleteKlantInfo(KlantInfo klantInfo){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(KlantInfo.class, klantInfo.getId());
            if(klantInfo != null)  entityManager.remove(klantInfo);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klantInfo;
    }


    public KlantInfo updateKlantInfo(KlantInfo klantInfo){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(KlantInfo.class, klantInfo.getId());
            entityManager.merge(klantInfo);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klantInfo;
    }

}
