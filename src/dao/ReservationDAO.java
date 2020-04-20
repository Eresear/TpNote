package dao;

import model.Offre;
import model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservationDAO extends DAO<Reservation> {

    public ReservationDAO(EntityManager entityManager){
        super(entityManager);
    }

    public List<Reservation> getAllReservations(){
        List<Reservation> reservations;
        try{
            TypedQuery<Reservation> query = entityManager.createQuery("SELECT reservation FROM Reservation reservation", Reservation.class);
            reservations = query.getResultList();
            return reservations;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean reserverOffre(String destination, String name, int nbEnfants, int nbEtudiants, int nbNormaux,double prixTotal){
        entityManager.getTransaction().begin();
        OffreDAO offreDAO = new OffreDAO(entityManager);
        Offre offre = offreDAO.getOffreByDestination(destination);
        int disponible = offre.getNbPlaces() -(nbNormaux+nbEnfants+nbEtudiants)  ;
        offre.setNbPlaces(disponible);

        Reservation reservation = new Reservation(name,nbEnfants,nbEtudiants,nbNormaux,prixTotal);
        reservation.setDestination(offre);

        entityManager.persist(reservation);
        entityManager.getTransaction().commit();
        return true;
    }
}
