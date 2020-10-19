package edm.piquete.modelo;

public enum AvariaTipo {
	
	Luz("Baixa Tens�o"),
	Contador("Alta Tens�o");
	
	
	private String label;
	
	private AvariaTipo (String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
