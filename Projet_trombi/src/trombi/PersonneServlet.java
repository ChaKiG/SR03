package trombi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class PersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 21L;

	public PersonneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom, prenom;
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		
		String text = "";
		ObjectMapper map = new ObjectMapper();
		Personne[] lPersonnes = new DataHandler(nom, prenom).getPersonnes();
		text =  map.writeValueAsString(lPersonnes);
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);
	}
}
