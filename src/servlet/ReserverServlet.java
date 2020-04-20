package servlet;

import dao.OffreDAO;
import dao.ReservationDAO;
import model.Offre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReservationServlet", urlPatterns = "/reservation")
public class ReserverServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher disp;
        String nomDestination = req.getParameter("pays");
        int tarif = Integer.parseInt(req.getParameter("tarif"));
        HttpSession session = req.getSession();
        session.setAttribute("pays",nomDestination);
        session.setAttribute("tarif",tarif);
        disp = req.getRequestDispatcher("addReservation.jsp");
        disp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        RequestDispatcher disp = req.getRequestDispatcher("addReservation.jsp");

        //Récupération des données
        String nomDestination = (String) session.getAttribute("pays");
        String name = req.getParameter("name");
        int nbAdultes = Integer.parseInt(req.getParameter("nbAdultes"));
        int nbEtudiants = Integer.parseInt(req.getParameter("nbEtudiants"));
        int nbEnfants = Integer.parseInt(req.getParameter("nbEnfants"));
        double prixTotal = Double.valueOf(req.getParameter("prixTotal"));


        if(prixTotal ==0 || name == null){
            session.setAttribute("reserverAlert","name or prixTotal est vide");
            disp.forward(req,resp);
            return;
        }

        ReservationDAO reservationDAO = new ReservationDAO(em);
        OffreDAO offreDAO = new OffreDAO(em);
        Offre offre = offreDAO.getOffreByDestination(nomDestination);

        //On vérifie la disponibilité des places
        int depasse =(nbAdultes+nbEnfants+nbEtudiants)-offre.getNbPlaces()  ;
        if (depasse > 0){
            session.setAttribute("reserverAlert","Vous avez dépasseé "+depasse+" de places ");
            disp.forward(req,resp);
            return;
        }

        reservationDAO.reserverOffre(nomDestination, name, nbEnfants, nbEtudiants, nbAdultes,prixTotal);

        session.setAttribute("pays",null);
        session.setAttribute("tarif",null);
        session.setAttribute("reserverAlert",null);

        resp.sendRedirect("Accueil");
    }
}
