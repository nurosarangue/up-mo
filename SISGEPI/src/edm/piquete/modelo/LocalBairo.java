package edm.piquete.modelo;

public enum LocalBairo {
	MARMANELO("Marmanelo"),
	SAMORA("Samora Machel"),
	CENTRAL("central"),
	MADEMO("Mademo"),
	FEVEREIRO("3 de Fevereiro"),
	LUGELA("Lugela"),
	JUNHO("16 de Junho"),
	SETEMBRO("25 de Setembro"),
	CFM("CFM"),
	MANGULAMELO("Mangulamelo"),
	DERUBA("Deruba"),
	AEROPORTO("Aeroporto 1°"),
	AERODROMO("Aeroporto 2°"),
	NAVERUA("Naverua"),
	YASSO("Yasso Marques");
	
	private String label;
	
	private LocalBairo(String label){
		this.label = label;

   }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
