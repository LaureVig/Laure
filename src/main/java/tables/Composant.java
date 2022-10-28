package tables;

import openclassroom.TypesComp;

public class Composant {
	private int id;
	private String nom;
	private String libelle;
	private String attribut_1;
	private String attribut_2;
	private String attribut_3;
	private String attribut_4;
	private String attribut_5;
	private int id_type_composant;
	private String nom_type_composant;
	
	public String getNom_type_composant() {
		return nom_type_composant;
	}
	public void setNom_type_composant(int id) {
		
		TypesComp test = new TypesComp();
		this.nom_type_composant = test.recupererNom(id_type_composant);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAttribut_1() {
		return attribut_1;
	}
	public void setAttribut_1(String attribut_1) {
		this.attribut_1 = attribut_1;
	}
	public String getAttribut_2() {
		return attribut_2;
	}
	public void setAttribut_2(String attribut_2) {
		this.attribut_2 = attribut_2;
	}
	public String getAttribut_3() {
		return attribut_3;
	}
	public void setAttribut_3(String attribut_3) {
		this.attribut_3 = attribut_3;
	}
	public String getAttribut_4() {
		return attribut_4;
	}
	public void setAttribut_4(String attribut_4) {
		this.attribut_4 = attribut_4;
	}
	public String getAttribut_5() {
		return attribut_5;
	}
	public void setAttribut_5(String attribut_5) {
		this.attribut_5 = attribut_5;
	}
	public int getId_type_composant() {
		return id_type_composant;
	}
	public void setId_type_composant(int id_type_composant) {
		this.id_type_composant = id_type_composant;
	}
	public void setNom_type_composant(String string) {
		// TODO Auto-generated method stub
		this.nom_type_composant=string;
	}
	
	
}
