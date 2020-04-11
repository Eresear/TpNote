package servlet;

import dao.DAO;
import dao.EmployesDao;
import model.Employes;

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

@WebServlet(name = "SigninServlet" ,urlPatterns = "/login")
public class SigninServlet extends HttpServlet {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("test");

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher disp;
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        EmployesDao employesDao = new EmployesDao(entityManager);
        if ( username!=null && pass != null && employesDao.checkLogin(username,pass) ) {
            session.setAttribute("authenticated", "yes");
            response.sendRedirect("/Accueil");
        } else {
            //session.setAttribute("authenticated", "no");
            request.setAttribute("msg","Username or password not correct");
            disp = request.getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
