package edm.piquete.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Reparacao implements Serializable{

	private static final long serialVersionUID = -4075899964592358466L;

	private Integer id;
	private String nome;
	private Instalacao instalacao;
	
	public Reparacao(){}
	
	public Reparacao(String nome, Instalacao instalacao) {
		super();
		this.nome = nome;
		this.instalacao = instalacao;
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Tipo de Residencia")
	public Instalacao getInstalacao() {
		return instalacao;
	}
	public void setInstalacao(Instalacao instalacao) {
		this.instalacao = instalacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparacao other = (Reparacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
