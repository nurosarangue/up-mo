package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.TipoDeAvaria;

public interface TipoAvariaServico {
	
	public void salvar(TipoDeAvaria tipoDeAvaria);
	public List<TipoDeAvaria> listarTodas();
	

}
