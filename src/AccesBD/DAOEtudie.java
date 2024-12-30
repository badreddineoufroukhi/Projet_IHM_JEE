package AccesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Element;
import Metier.ModaliteElem;
import Metier.ModaliteNote;

public class DAOEtudie {
	
	
	 private ArrayList<ModaliteElem> listModalite=new ArrayList<ModaliteElem>();
	 private Statement statement=null;
    ConnectionBD conn=new ConnectionBD();
    Connection connection=conn.ConnectionDb();
 
 public DAOEtudie() {
		super();
	}
 
	{
 try {
	 statement=connection.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
 }
 	
 	
	
	
	public ArrayList<ModaliteNote>  selectElemModuleString(String  elem) {
		ModaliteNote modalite;
        ArrayList<ModaliteNote> listeModaliteParElem=new ArrayList<ModaliteNote>();
			  try {
	  	    	  String req= "select nom_etudiant,prenom_etudiant,note from etudie, etudiant,element where etudie.cne=etudiant.cne and etudie.code_elem=element.code_elem and element.nom_elem=?";
	   			  PreparedStatement prepStatem=connection.prepareStatement(req);
			      prepStatem.setString(1,elem);
			      ResultSet res=prepStatem.executeQuery();
			  while(res.next()) {
				  modalite=new ModaliteNote(res.getString("nom_etudiant"),res.getString("nom_etudiant"),res.getInt("note"));
				 listeModaliteParElem.add(modalite);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

	return listeModaliteParElem;
}
	
}
