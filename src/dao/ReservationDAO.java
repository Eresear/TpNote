package dao;

import model.Offre;
import model.Reservation;

import javax.persistence.EntityManager;

public class ReservationDAO extends DAO<Reservation> {

    public ReservationDAO(EntityManager entityManager){
        super(entityManager);
    }

    public boolean reserverOffre(int idOffre, String name, int nbEnfants, int nbEtudiants, int nbNormaux,double prixTotal){
        entityManager.getTransaction().begin();
        Offre offre = entityManager.find(Offre.class, idOffre);
        int disponible =offre.getNbPlaces() -(nbNormaux+nbEnfants+nbEtudiants)  ;
        offre.setNbPlaces(disponible);

        Reservation reservation = new Reservation(name,nbEnfants,nbEtudiants,nbNormaux,prixTotal);
        reservation.setDestination(offre);

        entityManager.persist(reservation);
        entityManager.getTransaction().commit();
        return true;
    }
}
