package controllers;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
		response.getWriter().print("Failed with GET");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		if (mail == null || mdp == null) {
			doGet(request, response);
			return;
		}
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;	
				
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE mail = ? AND mot_de_passe = ?");
			stmt.setString(1, mail);
			stmt.setString(2, mdp);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				//rs.getBoolean("active");
				writer.print("Ok");
			} else {
				writer.print("Failed with POST");
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
