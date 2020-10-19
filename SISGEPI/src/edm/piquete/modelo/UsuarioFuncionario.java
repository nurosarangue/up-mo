package edm.piquete.modelo;

import javax.persistence.Entity;

@Entity

public class UsuarioFuncionario extends Usuario{

	private static final long serialVersionUID = -8369873100793515283L;

	

	private String grauIntrucao;
	
	public String getGrauIntrucao() {
		return grauIntrucao;
	}

	public void setGrauIntrucao(String grauIntrucao) {
		this.grauIntrucao = grauIntrucao;
	}

}
