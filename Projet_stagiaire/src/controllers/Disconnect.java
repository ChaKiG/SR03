package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession(false);
		response.setContentType("text/plain");
		Cookie c = null;
		
		if (session != null) {
			session.invalidate();
		}
		c = new Cookie("id", "-1");
	    c.setHttpOnly(true);
		c.setMaxAge(1);
		response.addCookie(c);
		response.getWriter().print("Ok");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
