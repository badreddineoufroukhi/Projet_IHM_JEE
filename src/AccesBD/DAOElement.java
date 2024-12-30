package AccesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Element;
import Metier.Professeur;

public class DAOElement {
	 private ArrayList<Element> listElem =new ArrayList<Element>();
	 private Statement statement=null;
     ConnectionBD conn=new ConnectionBD();
     Connection connection=conn.ConnectionDb();
    
    public DAOElement() {
		super();
	}
    
	{
    try {
   	 statement=connection.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
    
 	public ArrayList<Element>  selectAll() {
 		Element element ;
		try {
			ResultSet res=statement.executeQuery("select * from element");
			while(res.next()) {
				element=new Element(res.getInt("code_elem"), res.getString("nom_elem"), res.getInt("code_mod"), res.getInt("coefficient"));
				listElem.add(element);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listElem;
	}
  	public int selectElem(String nomElem) {
  		Element element=new Element() ;
		try {
 			String req="SELECT * FROM `element` WHERE element.nom_elem=?";
 			PreparedStatement prepStatem=connection.prepareStatement(req);
 			prepStatem.setString(1, nomElem);
 			ResultSet res=prepStatem.executeQuery();
 			while(res.next()) {
 				element=new Element(res.getInt("code_elem"), res.getString("nom_elem"), res.getInt("code_mod"), res.getInt("coefficient"));
 			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return element.getCodeElem();
  	}
}
