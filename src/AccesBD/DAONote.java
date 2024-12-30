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
import Metier.Note;




public class DAONote{
	
	 private Statement statement=null;
     ConnectionBD conn=new ConnectionBD();
     Connection connection=conn.ConnectionDb();
  
  public DAONote() {
		super();
	}
  
	{
  try {
 	 statement=connection.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
  	public ArrayList<ModaliteNote>  selectNoteparModalite(String nomm_modalite) {
  		ModaliteNote ListeNote;
        ArrayList<ModaliteNote> listeModaliteParElem=new ArrayList<ModaliteNote>();
			  try {
	  	    	  String req="select note,nom_modalite from note as no,modalite as mo where no.code_modalite=mo.code_modalite and nom_modalite=?";
	  	    	PreparedStatement prepStatem=connection.prepareStatement(req);
	 			prepStatem.setString(1, nomm_modalite);
	 			ResultSet res=prepStatem.executeQuery();
			  while(res.next()) {
				  ListeNote=new ModaliteNote(res.getInt("note"),res.getString("nom_modalite"));
				  listeModaliteParElem.add(ListeNote);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

	return listeModaliteParElem;
}
}
