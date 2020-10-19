package edm.piquete.modelo;

public enum AvariaTipo {
	
	Luz("Baixa Tensão"),
	Contador("Alta Tensão");
	
	
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
