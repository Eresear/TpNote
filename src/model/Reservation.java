package model;

import javafx.collections.ObservableList;

import javax.persistence.*;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReservation;
    private String nomClient;
    private int prix;
    private int enfants;
    private int etudiants;
    private int normaux;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offre offre;

    public Reservation(){

    }

    public Reservation(String nomClient, int prix) {
        this.nomClient = nomClient;
        this.prix = prix;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public int getPrix() {
        return prix;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
