package edm.piquete.modelo;

public enum TipoProfissao {

	Tecnico("Técico"),
	Operador("Operador"),
	Admin("Adminustrador");
	
	private String label;

	private TipoProfissao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
