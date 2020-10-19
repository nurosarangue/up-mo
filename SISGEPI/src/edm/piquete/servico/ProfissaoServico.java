package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Profissao;

public interface ProfissaoServico {

	public void salvar(Profissao profissao);
	public List<Profissao> listarTodos();
	public void excluir(Profissao profissao);
	public List<Profissao> listarProfissaoAccordion();
}
