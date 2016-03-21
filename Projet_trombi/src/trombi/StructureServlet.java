package trombi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class StructureServlet
 */
@WebServlet("/StructureServlet")
public class StructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StructureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int structId, sousStructId;
		structId = Integer.parseInt( request.getParameter("structId"));
		sousStructId = Integer.parseInt( request.getParameter("sousStructId"));
		
		String text = "";
		ObjectMapper map = new ObjectMapper();
		Personne[] lPersonnes = new DataHandler(structId , sousStructId).getPersonnes();
		text =  map.writeValueAsString(lPersonnes);
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
