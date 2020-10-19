package edm.piquete.modelo;

public enum RuaAvenida {
	AVENIDA("Av. S. Machel"),
	RUA("Rua Julios Nherrere"),
	ESTRADA("Av. Ed. Mondlane"),
	CAMINHO("Av. Josina Machel");
	
	private String label;
	private RuaAvenida(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
