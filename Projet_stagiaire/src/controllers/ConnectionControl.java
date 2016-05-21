package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ConnectionControl {
	private boolean isOk;
	private Integer id;
	private String mail;
	private Integer type_utilisateur;
	private String cookieId;

	public boolean isOk() { return isOk; }
	public Integer id() { return id; }
	public String mail() { return mail; }
	public String cookieId() { return cookieId; }
	public Integer type_utilisateur() { return type_utilisateur; }
	
	
	public ConnectionControl() {
		isOk = false;
		mail = "";
		id = -1;
		cookieId = "";
		type_utilisateur = 0;
	};
	
	public ConnectionControl(HttpServletRequest request) {
		id = (Integer)request.getSession().getAttribute("id");
		mail = (String)request.getSession().getAttribute("mail");
		cookieId = (String)request.getSession().getAttribute("cookieId");
		type_utilisateur = (Integer)request.getSession().getAttribute("type_utilisateur");
		
		String cookie = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0, n = cookies.length; i < n; i++) {
				if (cookies[i].getName().equals("id")) {
					cookie = cookies[i].getValue();
					break;
				}
			}
		}
		if ( type_utilisateur != null && mail != null && id != null && cookieId.equals(cookie) ) {
			isOk = true;
		} else {
			isOk = false;
		}
	}
}
