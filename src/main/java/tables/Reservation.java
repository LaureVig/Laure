package tables;

import java.sql.Date;

public class Reservation {
	private int id_reserv;
	private String nom;
	private String libelle;
	private int indice;
	private Date date_creation;
	private Date date_liberation;
	private int actif;
	private String commentaire;
	private int id_user;
	private int id_env;
	
	
	public int getId_reserv() {
		return id_reserv;
	}
	public void setId_reserv(int id_reserv) {
		this.id_reserv = id_reserv;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_liberation() {
		return date_liberation;
	}
	public void setDate_liberation(Date date_liberation) {
		this.date_liberation = date_liberation;
	}
	public int getActif() {
		return actif;
	}
	public void setActif(int actif) {
		this.actif = actif;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_env() {
		return id_env;
	}
	public void setId_env(int id_env) {
		this.id_env = id_env;
	}
	
}
