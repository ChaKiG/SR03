package controllers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import beans.Utilisateur;
import dao.UtilisateurDAO;


public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public Connect() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().print("Error");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
	
		if (mail == null || mdp == null) {
			doGet(request, response);
			return;
		}
		
		try {
			Utilisateur u = UtilisateurDAO.getUtilisateur(mail);
			if ( u.mot_de_passe.equals(mdp) && u.mail.equals(mail) ) {
				if ( u.active == 1 ) {
					String id = UUID.randomUUID().toString();
					Cookie cookieId = new Cookie("id", id);
				    cookieId.setHttpOnly(true);
					response.addCookie( cookieId );
					session.setAttribute( "mail", u.mail );
					session.setAttribute( "type_utilisateur", u.type_utilisateur );
					session.setAttribute( "id", id );
					writer.print( "Ok" );
				} else {
					writer.print( "Inactive" );
				}
			} else {
				writer.print( "Inexistant" );
			}
		} catch (Exception e) {
			e.printStackTrace();
			try { writer.print( "Error" ); } catch (Exception ep) {}
		}
	}

}
