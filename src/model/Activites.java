package model;

import javax.persistence.*;

@Entity
public class Activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivite;
    private String nomActivite;

    @ManyToOne()
    private Offre destination;

    public Activites(){

    }


    public Activites(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public Offre getNomOffre() {
        return destination;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public void setNomOffre(Offre destination) {
        this.destination = destination;
    }
}
