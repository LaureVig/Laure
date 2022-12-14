package openclassroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import tables.Composant;

public class Composants {
    private Connection connexion;
    
    public List<Composant> recupererComposants() {
    	List<Composant> comps = new ArrayList<Composant>();
    	Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        try {
            statement = connexion.createStatement();

            // Ex?cution de la requ?te
            resultat = statement.executeQuery("SELECT * FROM composant");
            		
            // R?cup?ration des donn?es
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String libelle = resultat.getString("libelle");
                String attribut_1 = resultat.getString("attribut_1");
                String attribut_2 = resultat.getString("attribut_2");
                String attribut_3 = resultat.getString("attribut_3");
                String attribut_4 = resultat.getString("attribut_4");
                String attribut_5 = resultat.getString("attribut_5");
                int id_type_composant = resultat.getInt("id_type_composant");
                
                Composant comp = new Composant();
                comp.setNom(nom);
                comp.setLibelle(libelle);
                comp.setAttribut_1(attribut_1);
                comp.setAttribut_2(attribut_2);
                comp.setAttribut_3(attribut_3);
                comp.setAttribut_4(attribut_4);
                comp.setAttribut_5(attribut_5);
                comp.setId_type_composant(id_type_composant);
                PreparedStatement statement2 = connexion.prepareStatement("SELECT * FROM type_composant WHERE id_type_composant=?");
        		statement2.setInt(1, id_type_composant );
        		ResultSet resultat2=statement2.executeQuery();
        		String nom2 = "";
        		int i = 0;
        		while (resultat2.next()) {
        			i++;
        			nom2 = resultat2.getString("nom");
        		}
        		comp.setNom_type_composant(nom2);
                comps.add(comp);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return comps;
    }		
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
        	
            connexion = DriverManager.getConnection(
            	    "jdbc:mariadb://localhost:3306/scott",
            	    "root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterComposant(Composant composant) {
    	loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO composant (id_comp,nom,  libelle, attribut_1, attribut_2,attribut_3, attribut_4,attribut_5, id_type_composant)\r\n"
            		+ " VALUES (DEFAULT, ?, ?, ?, ?,?,?,?, (SELECT id_type_composant FROM type_composant WHERE id_type_composant=?));");
            preparedStatement.setString(1, composant.getNom());
            preparedStatement.setString(2, composant.getLibelle());
            preparedStatement.setString(3, composant.getAttribut_1());
            preparedStatement.setString(4, composant.getAttribut_2()); 
            preparedStatement.setString(5, composant.getAttribut_3());
            preparedStatement.setString(6, composant.getAttribut_4());
            preparedStatement.setString(7, composant.getAttribut_5());
            System.out.println(composant.getId_type_composant());
            preparedStatement.setInt(8, composant.getId_type_composant());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}