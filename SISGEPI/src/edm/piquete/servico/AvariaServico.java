package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Avaria;

public interface AvariaServico {

	public void salvar(Avaria avaria);
	public List<Avaria>listarTodos();
	public void apagar(Avaria avaria);
	public List<Avaria> listarAvariasAccordion();
	public List<Avaria> buscarAvariasPorPesquisa(String pesquisa);
	public List<Avaria> buscarAvariasBaixadas(String pesquisa);
	public List<Avaria> listarAvariasBaixadas();
	public void actualizar(Avaria avariaSelecionada);
}
