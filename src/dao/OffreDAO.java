package dao;

import model.Activites;
import model.ChoseAFaire;
import model.Offre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class OffreDAO extends DAO<Offre> {

    public OffreDAO(EntityManager entityManager){
        super(entityManager);
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
    public  Offre getOffreById(int id){
        return entityManager.find(Offre.class,id);
    }

    public boolean add(String lieu,String description,int tarif,int nbPlace,String[] choses,String[] activites ){

        try{
            entityManager.getTransaction().begin();
            Offre offre = new Offre(nbPlace,tarif,lieu,description);
            List<ChoseAFaire> choseAFaireList = new ArrayList<ChoseAFaire>();
            List<Activites> activitesList = new ArrayList<Activites>();
            for (String chose:choses ) {
                ChoseAFaire c = new ChoseAFaire(chose);
                c.setIdOffre(offre);
                choseAFaireList.add(c);
            }
            for (String activite :
                    activites) {
                Activites a = new Activites(activite);
                a.setNomOffre(offre);
                activitesList.add(a);
            }

            offre.setActivitesList(activitesList);
            offre.setChoseAFaireList(choseAFaireList);
            entityManager.persist(offre);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
