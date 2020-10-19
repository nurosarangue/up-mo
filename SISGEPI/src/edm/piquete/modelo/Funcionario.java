package edm.piquete.modelo;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class Funcionario extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8027551245173655119L;
	private String numeroFuncionario;
	private Date dataCadastro;
	public String getNumeroFuncionario() {
		return numeroFuncionario;
	}
	public void setNumeroFuncionario(String numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	

}
