package model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffre;
    private String nomDestination;
    private int nbPlaces;
    private int tarif;
    private String description;

    @OneToMany(mappedBy = "idOffre")
    private List<Activites> activitesList;
    @OneToMany(mappedBy = "idOffre")
    private List<ChoseAFaire> choseAFaireList;
    @OneToMany(mappedBy = "offre")
    private List<Reservation> reservationList;

    public Offre(){

    }

    public Offre(int nbPlaces, int tarif, String nomDestination, String description) {
        this.nbPlaces = nbPlaces;
        this.tarif = tarif;
        this.nomDestination = nomDestination;
        this.description = description;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public int getTarif() {
        return tarif;
    }

    public String getNomDestination() {
        return nomDestination;
    }

    public List<ChoseAFaire> getChoseAFaireList() {
        return choseAFaireList;
    }

    public List<Activites> getActivitesList() {
        return activitesList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public String getDescription() {
        return description;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public void setNomDestination(String nomDestination) {
        this.nomDestination = nomDestination;
    }

    public void setActivitesList(List<Activites> activitesList) {
        this.activitesList = activitesList;
    }

    public void setChoseAFaireList(List<ChoseAFaire> choseAFaireList) {
        this.choseAFaireList = choseAFaireList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
