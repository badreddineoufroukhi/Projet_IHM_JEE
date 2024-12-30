package AccesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.Professeur;




public class DAOProfesseur {
	 private ArrayList<Professeur> listProfesseur =new ArrayList<Professeur>();
	 private Statement statement=null;
     ConnectionBD conn=new ConnectionBD();
     Connection connection=conn.ConnectionDb();
     
     public DAOProfesseur() {
		super();
	}
     
	{
     try {
    	 statement=connection.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
     }
     
  	public ArrayList<Professeur> selectAllProf(){
  		Professeur professeur ;
 		try {
 			String req="select * from professeur";
 			ResultSet res=statement.executeQuery(req);
 			while(res.next()) {
 				professeur=new Professeur(res.getInt("code_prof"), res.getString("nom_prof"), res.getString("prenom_prof"), res.getString("specialite"),res.getInt("telephone"),res.getString("username"));
 				listProfesseur.add(professeur);
 			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listProfesseur;
  		
  	}
  	
  	
  	public ArrayList<Professeur> selectProfwithusername(String username){
 			Professeur professeur=new Professeur() ;
 			try {
 	 			String req="SELECT * FROM professeur WHERE professeur.username = ?";
 	 			PreparedStatement preparStat=connection.prepareStatement(req);
 	 			preparStat.setString(1, username);
 	 			ResultSet res=preparStat.executeQuery();
 	 			while(res.next()) {
 	 				professeur=new Professeur(res.getInt("code_prof"), res.getString("nom_prof"), res.getString("prenom_prof"), res.getString("specialite"),res.getInt("telephone"),res.getString("username"));
 	 				listProfesseur.add(professeur);
 	 			}
 			} catch (Exception e) {
 				// TODO: handle exception
 			}
		return listProfesseur;
  		
  	}
  	
 
  	
  	
  	public int selectprof(String nomProf,String prenomProf) {
  		Professeur professeur=new Professeur() ;
		try {
 			String req="SELECT * FROM professeur WHERE professeur.nom_prof = ? and professeur.prenom_prof=?";
 			PreparedStatement preparStat=connection.prepareStatement(req);
 			preparStat.setString(1, nomProf);
 			preparStat.setString(2, prenomProf);
 			ResultSet res=preparStat.executeQuery();
 			while(res.next()) {
 				professeur=new Professeur(res.getInt("code_prof"), res.getString("nom_prof"), res.getString("prenom_prof"), res.getString("specialite"),res.getInt("telephone"),res.getString("username"));
 
 			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	return professeur.getCodeProf();
  	}

//  	{
//  		conn.closeConnection();
//  	}
}
