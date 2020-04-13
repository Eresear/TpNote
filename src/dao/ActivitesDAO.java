package dao;

import model.Activites;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ActivitesDAO extends DAO<Activites> {

    public ActivitesDAO(EntityManager entityManager){
        super(entityManager);
    }



    public String getAllActivites(String destination){
        List<String> activites;
        try{
            Query query = entityManager.createQuery("SELECT activites.nomActivite FROM Activites activites " +
                    "WHERE activites.destination.nomDestination=:destination");
            query.setParameter("destination", destination);
            activites = query.getResultList();
            return String.join(",", activites);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
