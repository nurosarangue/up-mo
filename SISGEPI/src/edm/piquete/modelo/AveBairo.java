package edm.piquete.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AveBairo implements Serializable{

	private static final long serialVersionUID = 7816369828110839580L;

	private Long id;
	private Bairo bairo;
	private Avenida avenida;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Bairo getBairo() {
		return bairo;
	}
	public void setBairo(Bairo bairo) {
		this.bairo = bairo;
	}
	public Avenida getAvenida() {
		return avenida;
	}
	public void setAvenida(Avenida avenida) {
		this.avenida = avenida;
	}
	
}
