package dao;

import model.Activites;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChoseAFaireDAO extends DAO<Activites> {

    public ChoseAFaireDAO(EntityManager entityManager){
        super(entityManager);
    }


    public String getAllChoseAFaier(String destination){
        List<String> chosesAFaire;
        try{
            Query query = entityManager.createQuery("SELECT chosesAFaire.nomChose FROM ChoseAFaire chosesAFaire " +
                    "WHERE chosesAFaire.destination=:destination");
            query.setParameter("destination", destination);
            chosesAFaire = query.getResultList();
            return String.join("," , chosesAFaire);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
