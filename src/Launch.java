import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Launch {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("test");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //ActivitesDAO activitesDAO = new ActivitesDAO(entityManager);

        //System.out.println(activitesDAO.getAllActivites("Portugal"));
        /*Offre offre1 = new Offre(100, 300, "Portugal", "Pays Européen");
        Offre offre2 = new Offre(150, 250, "Italie", "Pays Européen");
        Offre offre3 = new Offre(150, 400, "États-Unis", "Pays Américain");
        Offre offre4 = new Offre(100, 500, "Thailand", "Pays Asiatique");


        Activites activites1 = new Activites("Randonnée");
        Activites activites2 = new Activites("Visiter Parc");
        Activites activites3 = new Activites("Assister à un spectacle");
        Activites activites4 = new Activites("Découverte ville");
        Activites activites5 = new Activites("Croisière");
        Activites activites6 = new Activites("Visiter musée");

        ChoseAFaire cafPortugal1 = new ChoseAFaire("Visiter Chateau Saint George", offre1);
        ChoseAFaire cafPortugal2 = new ChoseAFaire("Visiter Tour de Belem", offre1);
        ChoseAFaire cafPortugal3 = new ChoseAFaire("Visiter l'ascenseur de Santa Justa", offre1);

        ChoseAFaire cafItalie1 = new ChoseAFaire("Visiter Fontaine de Trévi", offre2);
        ChoseAFaire cafItalie2 = new ChoseAFaire("Visiter Le Colisée", offre2);
        ChoseAFaire cafItalie3 = new ChoseAFaire("Visiter le forum romain", offre2);

        ChoseAFaire cafUSA1 = new ChoseAFaire("Traverser ville des Fantômes", offre3);
        ChoseAFaire cafUSA2 = new ChoseAFaire("Visiter Lac Tahoé", offre3);
        ChoseAFaire cafUSA3 = new ChoseAFaire("Faire un surf à Hawaii", offre3);

        ChoseAFaire cafThai1 = new ChoseAFaire("Visiter l'île Similan", offre4);
        ChoseAFaire cafThai2 = new ChoseAFaire("Visiter les parcs nationaux de Thailand", offre4);
        ChoseAFaire cafThai3 = new ChoseAFaire("Aller voir les éléphants du Thailand", offre4);


        activites1.setNomOffre(offre1);
        activites2.setNomOffre(offre1);

        activites3.setNomOffre(offre2);
        activites4.setNomOffre(offre2);

        activites5.setNomOffre(offre3);

        activites6.setNomOffre(offre4);

        Employes employe1 = new Employes("Yang", "password", TypeTemps.TEMP_PARTIEL);
        Employes employe2 = new Employes("Nour", "password", TypeTemps.TEMP_PLEIN);

        entityManager.getTransaction().begin();
        entityManager.persist(offre1);
        entityManager.persist(offre2);
        entityManager.persist(offre3);
        entityManager.persist(offre4);
        entityManager.persist(cafItalie1);
        entityManager.persist(cafItalie2);
        entityManager.persist(cafItalie3);
        entityManager.persist(cafPortugal1);
        entityManager.persist(cafPortugal2);
        entityManager.persist(cafPortugal3);
        entityManager.persist(cafUSA1);
        entityManager.persist(cafUSA2);
        entityManager.persist(cafUSA3);
        entityManager.persist(cafThai1);
        entityManager.persist(cafThai2);
        entityManager.persist(cafThai3);
        entityManager.persist(activites1);
        entityManager.persist(activites2);
        entityManager.persist(activites3);
        entityManager.persist(activites4);
        entityManager.persist(activites5);
        entityManager.persist(activites6);
        entityManager.persist(employe1);
        entityManager.persist(employe2);
        entityManager.getTransaction().commit();*/

    }
}
