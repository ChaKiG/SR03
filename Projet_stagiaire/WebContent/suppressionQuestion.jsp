<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controllers.ConnectionControl" %> 
<%@ page import="beans.Question" %>
<%@ page import="dao.QuestionDAO" %>
<% 
	int question = Integer.valueOf(request.getParameter("qu"));
	int questionnaire = Integer.valueOf(request.getParameter("q"));
	ConnectionControl c = new ConnectionControl(request); 
	if ( !c.isOk() ) { 
		response.sendRedirect("index");
	}
	
	Question q = QuestionDAO.getQuestion( question);
	QuestionDAO.deleteQuestion( q);
	response.sendRedirect("modification?q=" + questionnaire);
%>