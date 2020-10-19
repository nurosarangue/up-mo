package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Bairo;

public interface BairoServico {

	public void salvar(Bairo bairo);
	public List<Bairo> listarTodos();
	public void excluir(Bairo bairo);
}
