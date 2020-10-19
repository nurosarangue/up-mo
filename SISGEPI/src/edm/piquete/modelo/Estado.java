package edm.piquete.modelo;

public enum Estado {

	MAPUTO("Maputo","MPT"),
	INHAMBANE("Inhambane","ING"),
	BEIRA("Beira","Br"),
	TETE("Teté", "Tt"),
	ZAMBEZIA("Zambezia", "ZBZ"),
	NAMPULA("Nampula", "NPL"),
	CABO("Cabo Delegado", "Cbl");
	
	private String label;
	private String sigla;
	
	private Estado(String label, String sigla) {
		this.label = label;
		this.sigla = sigla;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
