<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalculetteProxyid" scope="session" class="calculette.CalculetteProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalculetteProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCalculetteProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCalculetteProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        calculette.Calculette getCalculette10mtemp = sampleCalculetteProxyid.getCalculette();
if(getCalculette10mtemp == null){
%>
<%=getCalculette10mtemp %>
<%
}else{
        if(getCalculette10mtemp!= null){
        String tempreturnp11 = getCalculette10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String val1_1id=  request.getParameter("val116");
        int val1_1idTemp  = Integer.parseInt(val1_1id);
        String val2_2id=  request.getParameter("val218");
        int val2_2idTemp  = Integer.parseInt(val2_2id);
        int add13mtemp = sampleCalculetteProxyid.add(val1_1idTemp,val2_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String val1_3id=  request.getParameter("val123");
        int val1_3idTemp  = Integer.parseInt(val1_3id);
        String val2_4id=  request.getParameter("val225");
        int val2_4idTemp  = Integer.parseInt(val2_4id);
        int mul20mtemp = sampleCalculetteProxyid.mul(val1_3idTemp,val2_4idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(mul20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
case 27:
        gotMethod = true;
        String val1_5id=  request.getParameter("val130");
        int val1_5idTemp  = Integer.parseInt(val1_5id);
        String val2_6id=  request.getParameter("val232");
        int val2_6idTemp  = Integer.parseInt(val2_6id);
        int sou27mtemp = sampleCalculetteProxyid.sou(val1_5idTemp,val2_6idTemp);
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sou27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>