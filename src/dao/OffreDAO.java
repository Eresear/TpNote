package dao;

import model.Offre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OffreDAO extends DAO<Offre> {

    public OffreDAO(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public boolean add(Offre element) {
        return false;
    }

    @Override
    public boolean modify(Offre element) {
        return false;
    }

    @Override
    public Offre getObjectById(String id) {
        return null;
    }

    public List<Offre> getAllOffers(){
        List<Offre> livres;
        try{
            TypedQuery<Offre> query = entityManager.createQuery("SELECT offre FROM Offre offre", Offre.class);
            livres = query.getResultList();
            return livres;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
