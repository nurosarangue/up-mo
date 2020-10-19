package edm.piquete.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Avaria implements Serializable{
	

	private static final long serialVersionUID = 4497983208143416561L;
	
	private Long id;
	private Date dataCadastro;
	private Cliente cliente;
	private String detalhes;
	private boolean activa;
	private TipoDeAvaria tipoDeAvaria;
	private boolean resolvida;
	private Date dataresolucao;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		Avaria other = (Avaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@ManyToOne
	@JoinColumn(name="id_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	@ManyToOne
	@JoinColumn(name="id_tipoAvaria")
	public TipoDeAvaria getTipoDeAvaria() {
		return tipoDeAvaria;
	}
	public void setTipoDeAvaria(TipoDeAvaria tipoDeAvaria) {
		this.tipoDeAvaria = tipoDeAvaria;
	}
	public Date getDataresolucao() {
		return dataresolucao;
	}
	public void setDataresolucao(Date dataresolucao) {
		this.dataresolucao = dataresolucao;
	}
	public boolean isResolvida() {
		return resolvida;
	}
	public void setResolvida(boolean resolvida) {
		this.resolvida = resolvida;
	}
	
}
