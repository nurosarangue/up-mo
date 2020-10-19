package edm.piquete.modelo;

import javax.persistence.Entity;

@Entity
public class UsuarioCliente extends Usuario{

	private static final long serialVersionUID = -5049978101038773367L;

	private String PF;

	public String getPF() {
		return PF;
	}

	public void setPF(String pF) {
		PF = pF;
	}
	
}
