package edm.piquete.modelo;

public enum TurnoRecepcao {
	DIA("Manha"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String label;
	private TurnoRecepcao(String label){
		this.label = label;
		
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
