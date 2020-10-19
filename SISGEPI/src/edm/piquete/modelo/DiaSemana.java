package edm.piquete.modelo;

public enum DiaSemana {

	SEGUNDA("Segunda-Feira"),
	TERCA("Terça-Feira"),
	QUARTA("Quarta-Feira"),
	QUINTA("Quinta-Feira"),
	SEXTA("Sexta-Feira"),
	SABADO("Sabado"),
	DOMINGO("Domingo");
	
	private String label;

	private DiaSemana(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
