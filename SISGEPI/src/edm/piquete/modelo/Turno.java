package edm.piquete.modelo;

public enum Turno {

	DIA("Manha"),
	MANHA("Tarde"),
	NOITE("Noite");
	
	private String label;
	private Turno(String label){
		
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
