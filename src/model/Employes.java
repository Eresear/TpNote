package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Employes {

    @Id
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private TypeTemps typeTemps;

    public Employes(){

    }

    public Employes(String username, String password, TypeTemps typeTemps) {
        this.username = username;
        this.password = password;
        this.typeTemps = typeTemps;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public TypeTemps getTypeTemps() {
        return typeTemps;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeTemps(TypeTemps typeTemps) {
        this.typeTemps = typeTemps;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
