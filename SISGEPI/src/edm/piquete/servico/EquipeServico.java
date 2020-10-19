package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Equipe;
import edm.piquete.modelo.UsuarioFuncionario;

public interface EquipeServico {

	public List<Equipe> listarTodas();
	public void salvar(Equipe equipe);
	public List<UsuarioFuncionario> listarTodosActivos();
}
