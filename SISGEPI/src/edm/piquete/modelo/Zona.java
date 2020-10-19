package edm.piquete.modelo;

public enum Zona {

	MAGANJA("Maganja"),
	MOLOCUE("Molocu�"),
	GURRUE("Gurru�");
	
	private String label;
	
	private Zona(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
