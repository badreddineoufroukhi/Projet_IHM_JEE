package Entities;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AccesBD.DAOModule;
import Metier.Module;
import javax.servlet.RequestDispatcher;


@WebServlet("/ControleurModule")
public class ControleurModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControleurModule() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  DAOModule daoME=new DAOModule();
		 
	      ArrayList<Module> listME= new ArrayList<Module>();
	      listME=daoME.selectAll();
	      request.setAttribute("listME",listME);
	      RequestDispatcher requestDispatcher=request.getRequestDispatcher("ListModElem.jsp");
	      requestDispatcher .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
