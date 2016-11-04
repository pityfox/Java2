package banque.model;

public enum Titre {
	M("titre.M"), MME("titre.MME"), MLLE("titre.MLLE");

	private final String label;

	private Titre(String label) {
		this.label = label;

	}

	public String getLabel() {
		return label;
	}

}
