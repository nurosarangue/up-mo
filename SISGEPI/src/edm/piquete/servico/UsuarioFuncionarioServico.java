package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.UsuarioFuncionario;

public interface UsuarioFuncionarioServico {

	public void salvar(UsuarioFuncionario usuarioFuncionario);
	public List<UsuarioFuncionario> listarTodos();
	public List<UsuarioFuncionario> listarTodosActivos();
}
