package Entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AccesBD.DAOElement;
import AccesBD.DAOEnseigner;
import AccesBD.DAOEtudie;
import AccesBD.DAOModalite;
import AccesBD.DAOProfesseur;
import Metier.Element;
import Metier.Modalite;
import Metier.ModaliteElem;
import Metier.ModaliteNote;
import Metier.Professeur;

@WebServlet("/ControleurElementNote")
public class ControleurElementNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ControleurElementNote() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			DAOEtudie mods = new DAOEtudie();
		    ArrayList<ModaliteNote> Moda=new ArrayList<ModaliteNote>();
		    String chaine1=request.getParameter("ElementName");
		    Moda=mods.selectElemModuleString(chaine1);
		    request.setAttribute("FinaleListeNote",Moda);
	        RequestDispatcher requestDispatcher=request.getRequestDispatcher("LesNotes.jsp");
	        requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chaine=request.getParameter("inputliste1");
		
		request.setAttribute("ElementName",chaine);
	      doGet(request, response);
	}

}
