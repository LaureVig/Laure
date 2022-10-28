package openclassroom;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import openclassroom.Composants;
import tables.Composant;
import tables.TypeComposant;


/**
 * Servlet implementation class Test
 */

public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Composants tableNoms = new Composants();
        TypesComp tableTypes = new TypesComp();
        request.setAttribute("types", tableTypes.recupererTypes());
        request.setAttribute("composants", tableNoms.recupererComposants());       
        this.getServletContext().getRequestDispatcher("/WEB-INF/composants.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Composant composant =new Composant();
        composant.setNom(request.getParameter("nom"));
        composant.setLibelle(request.getParameter("libelle"));
        composant.setAttribut_1(request.getParameter("attribut_1"));
        composant.setAttribut_2(request.getParameter("attribut_2"));
        composant.setAttribut_3(request.getParameter("attribut_3"));
        composant.setAttribut_4(request.getParameter("attribut_4"));
        composant.setAttribut_5(request.getParameter("attribut_5"));
        composant.setId_type_composant(Integer.parseInt(request.getParameter("id_type_composant")));
        composant.setNom_type_composant(composant.getId_type_composant());
        System.out.println("nom : "+composant.getNom_type_composant());
        Composants composants = new Composants();
        composants.ajouterComposant(composant);
        request.setAttribute("composants", composants.recupererComposants());
        request.setAttribute("nomType", composants);
        TypesComp tableTypes = new TypesComp();
        request.setAttribute("types", tableTypes.recupererTypes());
        this.getServletContext().getRequestDispatcher("/WEB-INF/composants.jsp").forward(request, response);
    }
}