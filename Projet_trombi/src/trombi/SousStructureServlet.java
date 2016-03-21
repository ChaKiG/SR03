package trombi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class SousStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SousStructureServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lid = 0;
		lid = Integer.parseInt(request.getParameter("structure"));
		String text = "";
		if (lid != 0) {
			ObjectMapper map = new ObjectMapper();
			Structure[] sousStructure = DataHandler.getSousStructures(lid);
			text =  map.writeValueAsString(sousStructure);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
