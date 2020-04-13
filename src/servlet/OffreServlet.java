package servlet;

import dao.ActivitesDAO;
import dao.OffreDAO;
import model.Activites;
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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "offreController", urlPatterns = "/Accueil")
public class OffreServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("nomOffre") != null) {
            ActivitesDAO activitesDAO = new ActivitesDAO(em);
            String activites = activitesDAO.getAllActivites(req.getParameter("nomOffre") );
            req.setAttribute("listActivites", activites);
        } else {
            OffreDAO offreDAO = new OffreDAO(em);
            List<Offre> listOffres = offreDAO.getAllOffers();
            req.setAttribute("listOffres", listOffres);
            //String activites = activitesDAO.getAllActivites(offre);
            RequestDispatcher dispatcher = req.getRequestDispatcher("accueil.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
