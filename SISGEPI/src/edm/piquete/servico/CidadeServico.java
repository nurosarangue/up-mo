package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Estado;

public interface CidadeServico {

	public void salvar(Cidade cidade);
	public List<Cidade> listarTodas();
	public void excluir(Cidade cidade);
	public List<Cidade> obterCidadesDoEstado(Estado estado);
}
