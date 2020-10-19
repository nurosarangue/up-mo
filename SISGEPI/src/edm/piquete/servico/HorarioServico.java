package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Horario;

public interface HorarioServico {

	public Horario salvar(Horario horario);
	public List<Horario> listarPorEquipe(Integer idEquipe);
	
}
