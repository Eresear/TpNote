package model;

import javax.persistence.*;

@Entity
public class Activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivite;
    private String nomActivite;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offre idOffre;

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

    public Offre getIdOffre() {
        return idOffre;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public void setIdOffre(Offre idOffre) {
        this.idOffre = idOffre;
    }
}
