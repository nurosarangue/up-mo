package edm.piquete.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class Manutencao {

	private String tipo;
	private Reparacao reparacao = new Reparacao();
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@ManyToOne
	@JoinColumn(name = "id_reparacao")
	@NotNull(message = "Selecione Residencia")
	public Reparacao getReparacao() {
		return reparacao;
	}
	public void setReparacao(Reparacao reparacao) {
		this.reparacao = reparacao;
	}
	
	
}
