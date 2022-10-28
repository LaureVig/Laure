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
import tables.TypeComposant;

public class TypesComp {
    private Connection connexion;
    
    public String recupererNom(int id) {
    	PreparedStatement statement = null;
    	ResultSet resultat = null;
    	String nom = null;
    	loadDatabase();
    	try {
    		statement = connexion.prepareStatement("SELECT * FROM type_composant WHERE id_type_composant=?");
    		statement.setInt(1, id );
    		resultat=statement.executeQuery();
    		
    		while (resultat.next()) {
    			nom = resultat.getString("nom");
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
    	return nom;
    }
    public List<TypeComposant> recupererTypes() {
    	List<TypeComposant> comps = new ArrayList<TypeComposant>();
    	Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM type_composant");
            		
            // Récupération des données
            while (resultat.next()) {
            	int id_type_composant = resultat.getInt("id_type_composant");
                String nom = resultat.getString("nom");
                String libelle = resultat.getString("libelle");
                String type_entite = resultat.getString("type_entite");
                String attribut_1 = resultat.getString("attribut_1");
                String attribut_2 = resultat.getString("attribut_2");
                String attribut_3 = resultat.getString("attribut_3");
                String attribut_4 = resultat.getString("attribut_4");
                String attribut_5 = resultat.getString("attribut_5");
                
                TypeComposant comp = new TypeComposant();
                comp.setId_type_composant(id_type_composant);
                comp.setNom(nom);
                comp.setLibelle(libelle);
                comp.setType_entite(type_entite);
                comp.setAttribut_1(attribut_1);
                comp.setAttribut_2(attribut_2);
                comp.setAttribut_3(attribut_3);
                comp.setAttribut_4(attribut_4);
                comp.setAttribut_5(attribut_5);
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
    
    public void ajouterTypeComposant(TypeComposant composant) {
    	loadDatabase();
        //TODO : Adapter ça au type de composant si besoin, sinon, l'enlever
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO composant (id_comp,nom,  libelle, attribut_1, attribut_2,attribut_3, attribut_4,attribut_5, id_type_composant)\r\n"
            		+ " VALUES (DEFAULT, ?, ?, ?, ?,?,?,?, (SELECT id_type_composant FROM type_composant WHERE nom=?));");
            preparedStatement.setString(1, composant.getNom());
            preparedStatement.setString(2, composant.getLibelle());
            preparedStatement.setString(3, composant.getAttribut_1());
            preparedStatement.setString(4, composant.getAttribut_2()); 
            preparedStatement.setString(5, composant.getAttribut_3());
            preparedStatement.setString(6, composant.getAttribut_4());
            preparedStatement.setString(7, composant.getAttribut_5());
            preparedStatement.setInt(8, composant.getId_type_composant());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
