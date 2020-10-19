package edm.piquete.modelo;

public enum TipoEstalacao {
	CREDELEC("Pr�-pago"),
	CONVENCIONAL("Pr�s-pago");
	
	private String label;
	
	private TipoEstalacao(String label) {
	
	this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
