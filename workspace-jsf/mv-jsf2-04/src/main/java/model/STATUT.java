package model;

public enum STATUT {

	SE("Sans Emploi"), EA("En Activité"), R("Retraité");
	
	private String label;

	private STATUT(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
