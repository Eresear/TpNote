package servlet;

import dao.ReservationDAO;

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

@WebServlet(name = "ReservationServlet", urlPatterns = "/reservation")
public class ReserverServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher disp;
        disp = req.getRequestDispatcher("addReservation.jsp");
        disp.forward(req, resp);
        String nomDestination = req.getParameter("pays");
        ReservationDAO reservationDAO = new ReservationDAO(em);

        String name = req.getParameter("name");
        int nbAdultes = Integer.parseInt(req.getParameter("nbAdultes"));
        int nbEtudiants = Integer.parseInt(req.getParameter("nbEtudiants"));
        int nbEnfants = Integer.parseInt(req.getParameter("nbEnfants"));

        reservationDAO.reserverOffre(nomDestination, name, nbEnfants, nbEtudiants, nbAdultes);
        resp.sendRedirect("/Accueil");
    }
}
