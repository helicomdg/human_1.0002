package repository;
import entity.Klant;
import entity.KlantInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
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
    public KlantInfo getKlantInfo(Long id) {
        KlantInfo klantInfo1 = null;
        try{
            entityManager.getTransaction().begin();
            String jpql = "select i from KlantInfo i where i.id = :id";
            TypedQuery<KlantInfo> klantInfo = entityManager.createQuery(jpql, KlantInfo.class);
            klantInfo1 = klantInfo.setParameter("id", id).getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klantInfo1;
    }
    public KlantInfo findKlantInfoByid(Long id) {
        KlantInfo klantInfo = entityManager.find(KlantInfo.class, id);
        if (klantInfo == null) {
            throw new EntityNotFoundException("Can't find klant for ID "
                    + id);
        }
        return klantInfo;
    }

}
