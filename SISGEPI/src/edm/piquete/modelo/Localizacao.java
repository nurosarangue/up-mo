package edm.piquete.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Localizacao {

	private Unidade unidade = new Unidade();

	@ManyToOne
	@JoinColumn(name = "id_unidade")
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
}
