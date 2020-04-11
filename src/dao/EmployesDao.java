package dao;

import model.Employes;

import javax.persistence.EntityManager;

public class EmployesDao extends DAO<Employes> {

    public EmployesDao(EntityManager entityManager){
        super(entityManager);
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
