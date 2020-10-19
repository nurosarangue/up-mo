package edm.piquete.modelo;

import java.util.Date;
import java.util.List;

public class ParametrosBuscaCliente {

	private Cliente cliente;
	private List<Bairo> bairos;
	private Date DataParticipacao;
	private Date DataResolucao;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Bairo> getBairos() {
		return bairos;
	}
	public void setBairos(List<Bairo> bairos) {
		this.bairos = bairos;
	}
	public Date getDataParticipacao() {
		return DataParticipacao;
	}
	public void setDataParticipacao(Date dataParticipacao) {
		DataParticipacao = dataParticipacao;
	}
	public Date getDataResolucao() {
		return DataResolucao;
	}
	public void setDataResolucao(Date dataResolucao) {
		DataResolucao = dataResolucao;
	}
	
}
