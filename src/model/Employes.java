package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employes {

    @Id
    private String pseudo;
    private String pass;
    private String nomprenom;
    private String adresse;
    private LocalDate dateDeNaissance;

    @Enumerated(EnumType.STRING)
    private TypeTemps typeTemps;

    public Employes(){

    }



    public Employes(String username, String password, TypeTemps typeTemps, String nomprenom, String adresse, LocalDate dateDeNaissance) {
        this.pseudo = username;
        this.pass = password;
        this.typeTemps = typeTemps;
        this.nomprenom = nomprenom;
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
    }

    public Employes(String username, String pass) {
        this.pseudo = username;
        this.pass = pass;
    }

    public String getUsername() {
        return pseudo;
    }

    public String getPassword() {
        return pass;
    }

    public TypeTemps getTypeTemps() {
        return typeTemps;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public void setTypeTemps(TypeTemps typeTemps) {
        this.typeTemps = typeTemps;
    }

    public void setUsername(String username) {
        this.pseudo = username;
    }

    public String getNomprenom() {
        return nomprenom;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

}
