package Metier;

public class ModaliteNote {
	private String nom_etudiant;
	private String prenom_etudiant;
	private int note;
	public ModaliteNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModaliteNote(String nom_etudiant, String prenom_etudiant, int note) {
		super();
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.note = note;
	}
	public String getNom_etudiant() {
		return nom_etudiant;
	}
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}
	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	
	
}
