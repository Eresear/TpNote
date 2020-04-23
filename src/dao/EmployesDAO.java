package dao;

import model.Employes;
import model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployesDAO extends DAO<Employes> {

    public EmployesDAO(EntityManager entityManager){
        super(entityManager);
    }

    public List<Employes> getAllEmployes(){
        List<Employes> employes;
        try{
            TypedQuery<Employes> query = entityManager.createQuery("SELECT employe FROM Employes employe", Employes.class);
            employes = query.getResultList();
            return employes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public Employes getObjectById(String id) {
        Employes employe = entityManager.find(Employes.class,id );
        return  employe;
    }

    public boolean checkLogin(String username ,String password){
        Employes employe = getObjectById(username);
        if (employe==null) return false;
        return password.equals(employe.getPassword());
    }

}
