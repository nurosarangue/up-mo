package edm.piquete.modelo;

public enum ZonaArea {
	
	MOCUBA("Mocuba"),
	GURRUE("Gurrue"),
	MOLOCUE("Molocue"),
	MILANGE("Milange"),
	PEBANE("Pebane"),
	LUGELA("Lugela"),
	MAGANJA("Maganja"),
	MOCUBELA("Mocubela"),
	MUGEBA("Mugeba");
	
	private String label;
	private ZonaArea(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	

}
