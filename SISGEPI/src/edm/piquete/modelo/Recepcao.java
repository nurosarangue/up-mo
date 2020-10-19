package edm.piquete.modelo;

public enum Recepcao {
	
	DIA("Manha"),
	MANHA("Tarde"),
	NOITE("Noite");
	
	private String label;
	
	private Recepcao(String label){
		this.label = label;
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
