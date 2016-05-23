package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDAO;

/**
 * Servlet implementation class userCreate
 */
@WebServlet(name = "UserCreate", urlPatterns = { "/user/create" })
public class userCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des paramètres
		String mail = request.getParameter("mailUser");
		String mot_de_passe = request.getParameter("mailUser");
		int type = Integer.parseInt( request.getParameter("mailUser"));
		Boolean actif = Boolean.valueOf( request.getParameter("mailUser"));
		String telephone = request.getParameter("mailUser");
		String societe = request.getParameter("mailUser");
		
		// Création de l'utilisateur via UtilisateurDAO
		UtilisateurDAO.createUtilisateur(mail, mot_de_passe, type, actif, telephone, societe);
		
	}

}
