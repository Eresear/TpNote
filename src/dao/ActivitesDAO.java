package dao;

import model.Activites;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActivitesDAO extends DAO<Activites> {

    public ActivitesDAO(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public boolean add(Activites element) {
        return false;
    }

    @Override
    public boolean modify(Activites element) {
        return false;
    }

    @Override
    public Activites getObjectById(String id) {
        return null;
    }

    public String getAllActivites(){
        List<String> activites;
        try{
            Query query = entityManager.createQuery("SELECT activites.nomActivite FROM Activites activites");
            activites = query.getResultList();
            return String.join(",", activites);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
