package trombi;

public class Structure {
	private int structNomId;
	private String auteurMaj;
	private String creDate;
	private String finValidite;
	private String harpComposante;
	private String modifDate;
	private String sigle;
	private String structureAbr;
	private String structureLibelle;
	private String structureLibelleAngl;
	private structure structure;

	public Structure() {}
	
	
	public int getStructNomId() {return structNomId;}
	public String getAuteurMaj() {return auteurMaj;}
	public String getCreDate() {return creDate;}
	public String getFinValidite() {return finValidite;}
	public String getHarpComposante() {return harpComposante;}
	public String getModifDate() {return modifDate;}
	public String getSigle() {return sigle;}
	public String getStructureAbr() {return structureAbr;}
	public String getStructureLibelle() {return structureLibelle;}
	public String getStructureLibelleAngl() {return structureLibelleAngl;}
	
	public void setStructNomId(int structNomId) {this.structNomId = structNomId;}
	public void setAuteurMaj(String auteurMaj) {this.auteurMaj = auteurMaj;}
	public void setCreDate(String creDate) {this.creDate = creDate;}
	public void setFinValidite(String finValidite) {this.finValidite = finValidite;}
	public void setHarpComposante(String harpComposante) {this.harpComposante = harpComposante;}
	public void setModifDate(String modifDate) {this.modifDate = modifDate;}
	public void setSigle(String sigle) {this.sigle = sigle;}
	public void setStructureAbr(String structureAbr) {this.structureAbr = structureAbr;}
	public void setStructureLibelle(String structureLibelle) {this.structureLibelle = structureLibelle;}
	public void setStructureLibelleAngl(String structureLibelleAngl) {this.structureLibelleAngl = structureLibelleAngl;}

	
	public structure getStructure() {return structure;}
	public void setStructure(structure structure) {this.structure = structure;}



	protected class structure {
		private int structId;
		private String dateFermeture;
		private String dateOuverture;
		private String gestRech$f;
		private String structureUt$f;
		private String titre;
		private String titreAn;
		private String trombi$f;

		public structure() {}

		public int getStructId() {return structId;}
		public String getDateFermeture() {return dateFermeture;}
		public String getDateOuverture() {return dateOuverture;}
		public String getStructureUt$f() {return structureUt$f;}
		public String getGestRech$f() {return gestRech$f;}
		public String getTitre() {return titre;}
		public String getTitreAn() {return titreAn;}
		public String getTrombi$f() {return trombi$f;}
		public void setTrombi$f(String trombi$f) {this.trombi$f = trombi$f;}
		public void setStructId(int structId) {this.structId = structId;}
		public void setDateFermeture(String dateFermeture) {this.dateFermeture = dateFermeture;}
		public void setDateOuverture(String dateOuverture) {this.dateOuverture = dateOuverture;}
		public void setStructureUt$f(String structureUt$f) {this.structureUt$f = structureUt$f;}
		public void setGestRech$f(String gestRech$f) {this.gestRech$f = gestRech$f;}
		public void setTitre(String titre) {this.titre = titre;}
		public void setTitreAn(String titreAn) {this.titreAn = titreAn;}
	}
}
