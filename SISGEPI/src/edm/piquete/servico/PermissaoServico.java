package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Permissao;

public interface PermissaoServico {
	
	public void salvar(Permissao permissao);
	public List<Permissao> listarTodas();

}
