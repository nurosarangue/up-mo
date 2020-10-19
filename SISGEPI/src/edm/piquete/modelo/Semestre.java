package edm.piquete.modelo;

public enum Semestre {

	PRIMEIRO("primeiro"),
	SEGUNDO("Segundo"),
	TERCEIRO("Terceiro"),
	QUARTO("Quarto");
	
	private String label;

	private Semestre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
