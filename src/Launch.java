import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Launch {

    public static void main(String[] args) {
        /*EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("test");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Offre offre1 = new Offre(100, 300, "Lisbonne", "Pays Européen, ville au Portugal");
        Offre offre2 = new Offre(150, 250, "Rome", "Pays Européen, ville en Italie");
        Offre offre3 = new Offre(150, 400, "NewYork", "État Américain, Pays Etats-Unis ");
        Offre offre4 = new Offre(100, 500, "Bangkok", "Pays Asiatique, ville en Chine");
        Offre offre5 = new Offre(100, 300, "Porto", "Pays Européen, ville au Portugal");



        Activites activites1 = new Activites("Randonnée");
        Activites activites2 = new Activites("Visiter Parc");
        Activites activites3 = new Activites("Assister à un spectacle");
        Activites activites4 = new Activites("Découverte ville");
        Activites activites5 = new Activites("Croisière");
        Activites activites6 = new Activites("Visiter musée");

        ChoseAFaire cafLisbonne1 = new ChoseAFaire("Visiter Chateau Saint George", offre1);
        ChoseAFaire cafLisbonne2 = new ChoseAFaire("Visiter Tour de Belem", offre1);
        ChoseAFaire cafLisbonne3 = new ChoseAFaire("Visiter l'ascenseur de Santa Justa", offre1);

        ChoseAFaire cafRome1 = new ChoseAFaire("Visiter Fontaine de Trévi", offre2);
        ChoseAFaire cafRome2 = new ChoseAFaire("Visiter Le Colisée", offre2);
        ChoseAFaire cafRome3 = new ChoseAFaire("Visiter le forum romain", offre2);

        ChoseAFaire cafNY1 = new ChoseAFaire("Traverser ville des Fantômes", offre3);
        ChoseAFaire cafNY2 = new ChoseAFaire("Visiter Lac Tahoé", offre3);
        ChoseAFaire cafNY3 = new ChoseAFaire("Faire un surf à Hawaii", offre3);

        ChoseAFaire cafBangkok1 = new ChoseAFaire("Visiter l'île Similan", offre4);
        ChoseAFaire cafBangkok2 = new ChoseAFaire("Visiter les parcs nationaux de Thailand", offre4);
        ChoseAFaire cafBangkok3 = new ChoseAFaire("Aller voir les éléphants du Thailand", offre4);

        ChoseAFaire cafPorto1 = new ChoseAFaire("Visiter les caves et déguster le Porto", offre5);
        ChoseAFaire cafPorto2 = new ChoseAFaire("Manger une Francesinha", offre5);
        ChoseAFaire cafPorto3 = new ChoseAFaire("Faire une croisière sur le Douro", offre5);

        activites1.setNomOffre(offre1);
        activites2.setNomOffre(offre1);

        activites3.setNomOffre(offre2);
        activites4.setNomOffre(offre2);

        activites5.setNomOffre(offre3);

        activites6.setNomOffre(offre4);

        Employes employe1 = new Employes("Yang", "password", TypeTemps.TEMP_PARTIEL,
                "Yang Yang", "Tours, France", LocalDate.of(1997, 5, 4));
        Employes employe2 = new Employes("Nour", "password", TypeTemps.TEMP_PLEIN,
                "Nour Nasrallah", "Paris, France", LocalDate.of(1997, 5, 20));

        entityManager.getTransaction().begin();
        entityManager.persist(offre1);
        entityManager.persist(offre2);
        entityManager.persist(offre3);
        entityManager.persist(offre4);
        entityManager.persist(cafRome1);
        entityManager.persist(cafRome2);
        entityManager.persist(cafRome3);
        entityManager.persist(cafLisbonne1);
        entityManager.persist(cafLisbonne2);
        entityManager.persist(cafLisbonne3);
        entityManager.persist(cafNY1);
        entityManager.persist(cafNY2);
        entityManager.persist(cafNY3);
        entityManager.persist(cafBangkok1);
        entityManager.persist(cafBangkok2);
        entityManager.persist(cafBangkok3);
        entityManager.persist(cafPorto1);
        entityManager.persist(cafPorto2);
        entityManager.persist(cafPorto3);
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
