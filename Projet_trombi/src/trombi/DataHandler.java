package trombi;

import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import trombi.Personne;


public class DataHandler {
	private Personne[] lPersonnes;
	
	public DataHandler(String nom, String prenom) {
		if (nom != null || prenom != null) {
			URL url = null;
			Scanner s = null;
			try {
				url = new URL("https://webapplis.utc.fr/Trombi_ws/mytrombi/result?nom=" + nom + "&prenom=" + prenom);
				s = new Scanner(url.openStream(), "UTF-8");
				s.useDelimiter("\\A");
				String json = s.next();
				lPersonnes = new ObjectMapper().readValue(json, TypeFactory.defaultInstance().constructArrayType(Personne.class));
				s.close();				
				for (Personne p : lPersonnes) {
					if (p.getAutorisation().equals("O")) {
						p.setPhoto("https://demeter.utc.fr/portal/pls/portal30/portal30.get_photo_utilisateur_mini?username=" + p.getLogin());
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public String getHtml() {
		String html = "";
		if (lPersonnes != null) {
			for (Personne p : lPersonnes) {
				html += "<div class=\"col-sm-4 divPers\">"
						+ "<div class=\"row\">"
						+ "<div class=\"col-xs-6\">";
				if (p.getAutorisation().equals("O"))
					html += "<img alt=\"Photo\" src=\"" + p.getPhoto() + "\" width=\"96px\" height=\"120px\"/>";
				else
					html += "<img alt=\"Photo\" src=\"img/no_image.jpg\" width=\"96px\" height=\"120px\"/>";
				html += "</div><div class=\"col-xs-6\"><p>"
						+ p.getNom() + "<br />"
						+ p.getPoste() + "<br />"
						+ p.getLogin() + "</div>"
						+ "</p></div></div>";
			}
		}
		return html;
	}
}
