package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OffreDAO {

    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("test");

    EntityManager entityManager = entityManagerFactory.createEntityManager();
}
