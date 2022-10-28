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
@WebServlet("/Test")
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
        
        Composants composants = new Composants();
        composants.ajouterComposant(composant);
        
        request.setAttribute("composants", composants.recupererComposants());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/composants.jsp").forward(request, response);
    }
}