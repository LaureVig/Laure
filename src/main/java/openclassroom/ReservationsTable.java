package openclassroom;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import tables.Composant;
import tables.Reservation;

public class ReservationsTable {
    private Connection connexion;
    
    public List<Reservation> recupererReservations() {
    	List<Reservation> reservations = new ArrayList<Reservation>();
    	Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM reservation");
            		
            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String libelle = resultat.getString("libelle");
                int id_user = resultat.getInt("id_user");
                int id_reserv = resultat.getInt("id_reserv");
            	int indice = resultat.getInt("indice");
            	Date date_creation = resultat.getDate("date_creation");
            	Date date_liberation = resultat.getDate("date_liberation");
            	int actif = resultat.getInt("actif");
            	String commentaire = resultat.getString("commentaire");
            	int id_env = resultat.getInt("id_env");
            	
                Reservation resa= new Reservation();
                resa.setNom(nom);
                resa.setLibelle(libelle);
                resa.setId_user(id_user);
                resa.setId_reserv(id_reserv);
                resa.setIndice(indice);
                resa.setDate_creation(date_creation);
                resa.setDate_liberation(date_liberation);
                resa.setActif(actif);
            	resa.setCommentaire(commentaire);
            	resa.setId_env(id_env);
//                PreparedStatement statement2 = connexion.prepareStatement("SELECT * FROM type_composant WHERE id_user=?");
//        		statement2.setInt(1, id_user );
//        		ResultSet resultat2=statement2.executeQuery();
//        		String nom2 = "";
//        		int i = 0;
//        		while (resultat2.next()) {
//        			i++;
//        			nom2 = resultat2.getString("nom");
//        		}
//        		comp.setNom_type_composant(nom2);
                reservations.add(resa);
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
        
        return reservations;
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