package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ConnectionControl {
	private boolean isOk;
	private String mail;
	private String id;
	private Integer type_utilisateur;

	public boolean isOk() { return isOk; }
	public String mail() { return mail; }
	public String id() { return id; }
	public Integer type_utilisateur() { return type_utilisateur; }
	
	
	public ConnectionControl() {
		isOk = false;
		mail = "";
		id = "";
		type_utilisateur = 0;
	};
	
	public ConnectionControl(HttpServletRequest request) {
		mail = (String)request.getSession().getAttribute("mail");
		id = (String)request.getSession().getAttribute("id");
		type_utilisateur = (Integer)request.getSession().getAttribute("type_utilisateur");
		
		String cookieId = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0, n = cookies.length; i < n; i++) {
				if (cookies[i].getName().equals("id")) {
					cookieId = cookies[i].getValue();
					break;
				}
			}
		}
		if ( type_utilisateur != null && mail != null && id != null && id.equals(cookieId) ) {
			isOk = true;
		} else {
			isOk = false;
		}
	}
}
