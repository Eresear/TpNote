package model;

import javax.persistence.*;

@Entity
public class ChoseAFaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChose;
    private String nomChose;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offre destination;

    public ChoseAFaire(){

    }

    public ChoseAFaire(String nomChose, Offre destination) {
        this.nomChose = nomChose;
        this.destination = destination;
    }
    public  ChoseAFaire(String nomChose){
        this.nomChose = nomChose;
    }

    public Offre getNomOffre() {
        return destination;
    }

    public int getIdChose() {
        return idChose;
    }

    public String getNomChose() {
        return nomChose;
    }

    public void setNomOffre(Offre destination) {
        this.destination = destination;
    }

    public void setNomChose(String nomChose) {
        this.nomChose = nomChose;
    }
}
