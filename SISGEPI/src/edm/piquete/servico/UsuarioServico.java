package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Usuario;

public interface UsuarioServico {

	public Usuario obterUsuarioPeloLogin(String login);
	public void salvar(Usuario usuario);
	public List<Usuario> listarTodos();
	public List<Usuario> listarTodosActivos();
	public String criptografarSenhaUsuario(String senhaFornecida);
	public boolean verificarSenhaDigitada(String senhaFornecida, String senhaBanco);
}
