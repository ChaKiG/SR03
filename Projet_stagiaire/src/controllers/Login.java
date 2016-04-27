package controllers;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	static final String DB_URL="jdbc:mysql://127.0.0.1:3306/projet_stagiaire";
	static final String USER = "projet_stagiaire";
	static final String PASS = "projet_stagiaire";
	
	public Login() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().print("Failed");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		
		if (mail == null || mdp == null) {
			doGet(request, response);
			return;
		}
				
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE mail = ? AND mot_de_passe = ?");
			stmt.setString(1, mail);
			stmt.setString(2, mdp);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String id = UUID.randomUUID().toString();
				session.setAttribute( "user", mail );
				session.setAttribute( "id", id );
				Cookie cookieId = new Cookie("id", id);
			    cookieId.setHttpOnly(true);
				response.addCookie( cookieId );
				writer.print("Ok");
			} else {
				writer.print("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { rs.close(); }catch (Exception e) {}
			try { stmt.close(); }catch (Exception e) {}
			try { conn.close(); }catch (Exception e) {}
		}
	}

}
