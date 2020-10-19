package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Horario;
import edm.piquete.servico.HorarioServico;

@Service("horarioServico")
@Transactional
public class HorarioServicoImpl implements HorarioServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Horario salvar(Horario horario) {
		return entityManager.merge(horario);
	}

	@Override
	public List<Horario> listarPorEquipe(Integer idEquipe) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
