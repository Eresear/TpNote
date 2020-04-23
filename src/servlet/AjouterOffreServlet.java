package servlet;

import dao.OffreDAO;

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

@WebServlet(name = "ajouterOffreServlet",urlPatterns = "/ajouterOffre")
public class AjouterOffreServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OffreDAO offreDAO = new OffreDAO(em);
        String lieu = request.getParameter("lieu");
        String desription = request.getParameter("description");
        HttpSession session = request.getSession();
        String[] choses = request.getParameterValues("Chosesfields[]");
        String[] activites = request.getParameterValues("Activitefields[]");

        int tarif = Integer.parseInt(request.getParameter("tarif"));
        int nbPlace = Integer.parseInt(request.getParameter("nbPlace")==""?"0":request.getParameter("nbPlace"));

        boolean parameterError =false;
        boolean succes =false;
        if (lieu==null || desription==null|| nbPlace==0 || tarif==0|| nbPlace==0||choses ==null ||choses[0]==null
            ||activites ==null|| activites[0]==null
        ){
           parameterError =true;
        }else {
             succes = offreDAO.add(lieu,desription,tarif,nbPlace,choses,activites);
        }
        if (succes){
            session.setAttribute("addOffreAlert","null");
        }else if (parameterError){
            session.setAttribute("addOffreAlert","il y a au moins un field qui est vide");
        }
        else session.setAttribute("addOffreAlert","L'insertion de l'offre rencontre une erreur");
        response.sendRedirect("Accueil");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp;
        disp = request.getRequestDispatcher("ajouterOffre.jsp");
        disp.forward(request, response);

    }
}
