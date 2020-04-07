package model;

import javax.persistence.*;

@Entity
public class ChoseAFaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChose;
    private String nomChose;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offre idOffre;


    public ChoseAFaire(){

    }

    public ChoseAFaire(String nomChose, Offre idOffre) {
        this.nomChose = nomChose;
        this.idOffre = idOffre;
    }

    public Offre getIdOffre() {
        return idOffre;
    }

    public int getIdChose() {
        return idChose;
    }

    public String getNomChose() {
        return nomChose;
    }

    public void setIdOffre(Offre idOffre) {
        this.idOffre = idOffre;
    }

    public void setNomChose(String nomChose) {
        this.nomChose = nomChose;
    }
}
