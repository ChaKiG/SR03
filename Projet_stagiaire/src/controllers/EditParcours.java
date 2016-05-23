package controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import beans.Parcours;
import beans.Utilisateur;
import dao.ParcoursDAO;
import dao.QuestionnaireDAO;
import dao.UtilisateurDAO;


public class EditParcours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public EditParcours() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().print("Error");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ConnectionControl c = new ConnectionControl(request); 
		if ( !c.isOk() ) { 
			response.getWriter().print("Error");
		} else {
			int questionnaire_id = Integer.valueOf(request.getParameter("q"));
			int utilisateur_id = c.id();
			Parcours p = ParcoursDAO.getParcours(questionnaire_id, utilisateur_id);
			long startedTime = (long) request.getSession().getAttribute(String.valueOf(questionnaire_id));
			p.duree.setTime(p.duree.getTime() + System.currentTimeMillis() - startedTime);
			
			Enumeration<String> rep = request.getParameterNames();
			while (rep.hasMoreElements()) {
				String parameter = rep.nextElement();
				if ( !parameter.equals("q")) {
					int question_id = Integer.valueOf(parameter);
					int reponse_id = Integer.valueOf(request.getParameter(parameter));
					ReponseUtilDAO.createReponse(p, utilisateur_id, reponse_id);
					if (reponse_id == QuestionDAO.getCorrectResponseId(question_id)) {
						p.score++;
					}
				}	
			}
			if (ParcoursDAO.updateParcours(p)) {
				response.setContentType("text/plain");
				response.getWriter().write("Ok");
			}
		}
	}

}
