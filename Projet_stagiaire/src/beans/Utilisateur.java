package beans;

import java.util.Date;

public class Utilisateur {
	public Integer id;
	public String mail;
	public String mot_de_passe;
	public Integer type_utilisateur;
	public Integer active;
	public String telephone;
	public String societe;
	public Date creation;
	
	public Utilisateur() {}
	public Utilisateur(int id, String mail, String mot_de_passe, 
			int type_utilisateur, int active, String telephone,
			String societe, Date creation) {
		this.id = id;
		this.mail = mail;
		this.mot_de_passe = mot_de_passe;
		this.type_utilisateur = type_utilisateur;
		this.active = active;
		this.telephone = telephone;
		this.societe = societe;
		this.creation = creation;
	}

}
