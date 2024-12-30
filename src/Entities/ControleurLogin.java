package Entities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AccesBD.DAOEnseigner;
import AccesBD.DAOProfesseur;
import Metier.Professeur;


@WebServlet("/ControleurLogin")
public class ControleurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControleurLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String username=request.getParameter("username");
              String password=request.getParameter("password");
              if(username.equals("derrar11") && password.equals("derrarderrar")) {
                  RequestDispatcher requestDispatcher=request.getRequestDispatcher("consulting.html");
                  requestDispatcher .forward(request, response);
              }
              if(username.equals("ihmnasrib") && password.equals("profensa5468")) {
            	  DAOProfesseur daoProf=new DAOProfesseur();
                  ArrayList<Professeur> listeProf= new ArrayList<Professeur>();
                  listeProf=daoProf.selectProfwithusername(username);
                  request.setAttribute("listeProf", listeProf);
                  RequestDispatcher requestDispatcher=request.getRequestDispatcher("LesElementsDeProf.jsp");
                  requestDispatcher .forward(request, response);
              }
              else {
                  RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.html");
                  requestDispatcher .forward(request, response);
              }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
