package servlet;

import dao.EmployesDao;
import dao.OffreDAO;
import dao.ReservationDAO;
import model.Employes;
import model.Offre;
import model.Reservation;

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

@WebServlet(name = "espaceAgenceController", urlPatterns = "/espaceAgence")
public class espaceAgenceServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationDAO ReservationDAO = new ReservationDAO(em);
        List<Reservation> listReservations = ReservationDAO.getAllReservations();
        req.setAttribute("listReservations", listReservations);

        EmployesDao employesDao = new EmployesDao(em);
        List<Employes> listEmployes = employesDao.getAllEmployes();
        req.setAttribute("listEmployes", listEmployes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("espaceAgence.jsp");
        dispatcher.forward(req, resp);

    }
}
