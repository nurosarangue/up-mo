package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Funcionario;

public interface FuncionarioServico {
	
	public void salvar(Funcionario funcionario);
	public List<Funcionario> ListarTodas();
	public Funcionario buscarFuncionarioexistente(String email, String nome, String numeroFuncionario);
	public List<Funcionario> obterFuncionarioPorPesquisa(String pesquisa);

}
