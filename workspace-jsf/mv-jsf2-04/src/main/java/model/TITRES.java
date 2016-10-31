package model;

public enum TITRES {
	Mr("Monsieur"), Mme ("Madame"), Mlle("Mademoiselle");
	
	private String label;

	private TITRES(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
