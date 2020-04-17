package dao;

import model.Offre;
import model.Reservation;

import javax.persistence.EntityManager;

public class ReservationDAO extends DAO<Reservation> {

    public ReservationDAO(EntityManager entityManager){
        super(entityManager);
    }

    public boolean reserverOffre(String destination, String name, int nbEnfants, int nbEtudiants, int nbNormaux){
        Offre offre = entityManager.find(Offre.class, destination);
        int prixOffre = offre.getTarif();
        double prixEnfant = 0;
        double prixEtudiant = 0;

        Reservation reservation = new Reservation();
        reservation.setDestination(offre);
        reservation.setEnfants(nbEnfants);
        reservation.setEtudiants(nbEtudiants);
        reservation.setNormaux(nbNormaux);
        reservation.setNomClient(name);

        if(nbEnfants != 0){
             prixEnfant = prixOffre/0.3;
        }
        if(nbEtudiants != 0){
             prixEtudiant = prixOffre/0.5;
        }

        double prixTotal = prixOffre + prixEnfant + prixEtudiant;

        reservation.setPrix(prixTotal);

        entityManager.persist(reservation);
        return false;
    }
}
