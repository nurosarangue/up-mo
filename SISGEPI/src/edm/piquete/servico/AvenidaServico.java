package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Avenida;

public interface AvenidaServico {

	public void salvar(Avenida avenida);
	public List<Avenida> listarTodas();
	public void excluir(Avenida avenida);
}
