package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Unidade;
import edm.piquete.modelo.Zona;

public interface UnidadeServico {

	public void salvar(Unidade unidade);
	public List<Unidade> listarTodas();
	public void excluir(Unidade unidade);
	public List<Unidade> obterUnidadesDaZona(Zona zona);
}
