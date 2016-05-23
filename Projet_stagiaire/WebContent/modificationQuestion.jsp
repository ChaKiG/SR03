<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="dao.SujetDAO" %>
<%@ page import="dao.UtilisateurDAO" %>
<%@ page import="dao.QuestionnaireDAO" %>
<%@ page import="dao.QuestionDAO" %>  
<%@ page import="dao.ReponseDAO" %>
<%@ page import="beans.Sujet" %>
<%@ page import="beans.Question" %>
<%@ page import="beans.Reponse" %>
<%@ page import="beans.Questionnaire" %>  
<% ConnectionControl c = new ConnectionControl(request); 
	if (!c.isOk() || c.type_utilisateur() < 1) {
		response.sendRedirect("index");
	}
	int questionnaire = Integer.valueOf(request.getParameter("q"));
	Questionnaire q = QuestionnaireDAO.getQuestionnaire( questionnaire);
	Question qu = QuestionDAO.getQuestion( Integer.valueOf(request.getParameter("qu")));
	List<Question> l = QuestionDAO.getQuestions( q);
	int nbq = l.size();
	// Récupérer les réponses
	List<Reponse> res = ReponseDAO.getReponses( qu);
	
	int id = -1;
	boolean ok = false;
	Question mqu = null;
	if (request.getParameter("nom") != null && request.getParameter("ordre") != null) {
		// Modification de la question
		mqu = new Question(
				Integer.valueOf( request.getParameter("quid")),
				QuestionnaireDAO.getQuestionnaire( Integer.valueOf( request.getParameter("qid"))),
				Integer.valueOf( request.getParameter("ordre")),
				request.getParameter("nom")
				);
		ok = QuestionDAO.modifyOrdre( mqu, Integer.valueOf( request.getParameter( "aordre")));
		
		// Modification des réponses
		if ( request.getParameter("nomr1") != null) {
			int correct = 0;
			if (request.getParameter("cr1") != null) {
				correct = 1;
			}
			Reponse mr1 = new Reponse(
					Integer.valueOf( request.getParameter("rid1")),
					QuestionDAO.getQuestion( Integer.valueOf( request.getParameter("quid"))),
					1,
					request.getParameter("nomr1"),
					correct
			);
			ReponseDAO.modifyReponse( mr1);
		}

		if ( request.getParameter("nomr2") != null) {
			int correct = 0;
			if (request.getParameter("cr2") != null) {
				correct = 1;
			}
			Reponse mr2 = new Reponse(
					Integer.valueOf( request.getParameter("rid2")),
					QuestionDAO.getQuestion( Integer.valueOf( request.getParameter("quid"))),
					2,
					request.getParameter("nomr2"),
					correct
			);
			ReponseDAO.modifyReponse( mr2);		
		}
		
		if ( request.getParameter("nomr3") != null) {
			int correct = 0;
			if (request.getParameter("cr3") != null) {
				correct = 1;
			}
			Reponse mr3 = new Reponse(
					Integer.valueOf( request.getParameter("rid3")),
					QuestionDAO.getQuestion( Integer.valueOf( request.getParameter("quid"))),
					1,
					request.getParameter("nomr3"),
					correct
			);
			ReponseDAO.modifyReponse( mr3);
		}
		
		questionnaire = Integer.valueOf(request.getParameter("q"));
		q = QuestionnaireDAO.getQuestionnaire( questionnaire);
		qu = QuestionDAO.getQuestion( Integer.valueOf(request.getParameter("qu")));
		l = QuestionDAO.getQuestions( q);
		nbq = l.size();
		res = ReponseDAO.getReponses( qu);
	}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'accueil</title>
</head>
<body>
	<%@ include file="navbar.html" %>
	<h1>Modification d'une question :</h1>
	<form method="POST">
		<input type="hidden" name="<%= "quid" %>" value="<%=qu.id %>">
		<input type="hidden" name="<%= "qid" %>" value="<%=q.id %>">
		<input type="hidden" name="<%= "aordre" %>" value="<%=qu.ordre %>">
		<label for="nom">Nom de la question :</label><br />
		<input type="text" id="nom" name="nom" placeholder="Nom" value="<%= qu.texte %>"/><br />
		<label for="ordre">Ordre :</label><br />
		<select id="ordre" name="ordre">
<%
	for (int i=1; i <= nbq + 1; i++) {
		if (i == qu.ordre) {
			%>
			<option value="<%= i %>" selected="selected"><%= i %></option>
			<% 
		} else {
			%>
			<option value="<%= i %>"><%= i %></option>
			<%
		}
	}
%>
		</select><br /><br />
		<label for="reponses">Réponses</label><br />
		<% 
			for (int i = 1; i <= res.size() ; i++) {
				Reponse rep = res.get(i-1);
				%>
				<input type="hidden" name="<%= "rid"+i %>" value="<%=rep.id %>">
				<label for="<%= "r"+i %>">Réponse <%=i %> :</label><br />
				<input type="text" id="<%= "nomr"+i %>" name="<%= "nomr"+i %>" placeholder="<%= "réponse "+i %>"  value="<%= rep.texte %>"/><br />
				<%
					if (rep.isCorrect == 1) {
						%>
						<label for="<%= "correctr"+i %>"><input type="checkbox" id="<%= "cr"+i %>" name="<%= "cr"+i %>" checked="checked">Correct?</label><br />
						<% 		
					} else {
						%>
						<label for="<%= "correctr"+i %>"><input type="checkbox" id="<%= "cr"+i %>" name="<%= "cr"+i %>">Correct?</label><br />
						<% 
					}
			}
		%>		
		<input type="hidden" name="q" value="<%= questionnaire %>">
		<input type="submit" value="Modifier" />
	</form>
	<% if ( ok == true) { %>
		<!-- TODO Rajouter la bonne redirection --> 
		<p>Question bien modifié ! Vous pouvez consulter l'ensemble des questions <a href="modification?q=<%= q.id %>">ici</a></p>
	<% } else if (mqu != null) {%>
		<p>Erreur, veuillez vérifier les informations</p>
	<% } %>
	<script src="js/js.js"></script>
</body>
</html>