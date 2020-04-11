package dao;

import model.Activites;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChoseAFaireDAO extends DAO<Activites> {

    public ChoseAFaireDAO(EntityManager entityManager){
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

    public String getAllChoseAFaier(int idOffre){
        List<String> chosesAFaire;
        try{
            Query query = entityManager.createQuery("SELECT chosesAFaire.nomChose FROM ChoseAFaire chosesAFaire " +
                    "WHERE chosesAFaire.idOffre=:idOffre");
            query.setParameter("idOffre", idOffre);
            chosesAFaire = query.getResultList();
            return String.join("," , chosesAFaire);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
