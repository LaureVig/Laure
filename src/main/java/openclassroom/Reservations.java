package openclassroom;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Reservations extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationsTable tableNoms = new ReservationsTable();
//        TypesComp tableTypes = new TypesComp();
//        request.setAttribute("types", tableTypes.recupererTypes());
        request.setAttribute("reservations", tableNoms.recupererReservations());       
		this.getServletContext().getRequestDispatcher("/WEB-INF/reservations.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
