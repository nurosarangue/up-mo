package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.Reparacao;


public interface ReparacaoServico {
	
	public void salvar(Reparacao reparacao);
	public List<Reparacao> listarTodas();
	public void excluir(Reparacao reparacao);
	public List<Reparacao> obterReparacoesDaIstalacao(Instalacao instalacao);

}
