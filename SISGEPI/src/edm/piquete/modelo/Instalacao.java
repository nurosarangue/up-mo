package edm.piquete.modelo;

public enum Instalacao {

	MONO("Monofasica"),
	BI("Bifasica"),
	TRI("Trifasica");
	
	private String label;
	
	private Instalacao(String label) {
		this.label = label;
	}

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
