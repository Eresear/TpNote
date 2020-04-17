package model;

import javafx.collections.ObservableList;

import javax.persistence.*;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private String nomClient;
    private double prix;
    private int enfants;
    private int etudiants;
    private int normaux;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offre destination;

    public Reservation(){

    }

    public Reservation(String nomClient, int enfants, int etudiants, int normaux, double prix) {
        this.nomClient = nomClient;
        this.prix = prix;
        this.enfants = enfants;
        this.etudiants = etudiants;
        this.normaux = normaux;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public double getPrix() {
        return prix;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Offre getDestination() {
        return destination;
    }

    public void setDestination(Offre destination) {
        this.destination = destination;
    }

    public int getEnfants() {
        return enfants;
    }

    public void setEnfants(int enfants) {
        this.enfants = enfants;
    }

    public int getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(int etudiants) {
        this.etudiants = etudiants;
    }

    public int getNormaux() {
        return normaux;
    }

    public void setNormaux(int normaux) {
        this.normaux = normaux;
    }
}
