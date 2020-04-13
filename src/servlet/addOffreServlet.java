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
import java.io.IOException;

@WebServlet(name = "addOffreServlet",urlPatterns = "/addOffre")
public class addOffreServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
    private EntityManager em = entityManagerFactory.createEntityManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OffreDAO offreDAO = new OffreDAO(em);
        String lieu = request.getParameter("lieu");
        String desription = request.getParameter("description");

        int tarif = Integer.parseInt(request.getParameter("tarif")==""?"0":request.getParameter("tarif"));
        int nbPlace = Integer.parseInt(request.getParameter("nbPlace")==""?"0":request.getParameter("nbPlace"));
        String[] choses = request.getParameterValues("Chosesfields[]");
        String[] activites = request.getParameterValues("Activitefields[]");
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
            request.setAttribute("alert",null);
            response.sendRedirect("Accueil");
            return;
        }

        if (parameterError){
            request.setAttribute("alert","il y a au moin un field qui est vide");
        }
        else request.setAttribute("alert","Inserer une offre rencontre une erreur");

        RequestDispatcher disp;
        disp = request.getRequestDispatcher("accueil.jsp");
        disp.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
