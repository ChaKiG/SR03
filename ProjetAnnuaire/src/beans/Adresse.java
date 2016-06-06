package beans;

public class Adresse {
	private int id;
	private int numero;
	private String rue;
	private String ville;
	private int cp;
	
	public Adresse() {}
	public Adresse(int id, int numero, String rue, String ville, int cp) {
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.cp = cp;
	}
	
	public int getId() { return this.id;}
	public int getNumero() { return this.numero;}
	public String getRue() { return this.rue;}
	public String getVille() { return this.ville;}
	public int getCp() { return this.cp;}
	
	public void setId(int id) {this.id = id;}
	public void setNumero(int numero) {this.numero = numero;}
	public void setRue(String rue) {this.rue = rue;}
	public void setVille(String ville) {this.ville = ville;}
	public void setCp(int cp) {this.cp = cp;}
}
