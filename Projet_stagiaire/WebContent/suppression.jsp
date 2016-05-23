<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="beans.Questionnaire" %>
<%@ page import="dao.QuestionnaireDAO" %>
<% 
	int questionnaire = Integer.valueOf(request.getParameter("q"));
	ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { 
		response.sendRedirect("index");
	}
	
	Questionnaire q = QuestionnaireDAO.getQuestionnaire( questionnaire);
	QuestionnaireDAO.deleteQuestionnaire( q);
	response.sendRedirect("questionnaires");
%>