package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Equipe;
import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.EquipeServico;

@Service("equipeServico")
@Transactional
public class EquipeServicoImpl implements EquipeServico{

	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipe> listarTodas() {
		return entityManager.createQuery("select e from Equipe e").getResultList();
	}

	@Override
	public void salvar(Equipe equipe) {
        entityManager.merge(equipe);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioFuncionario> listarTodosActivos() {
		return entityManager.createQuery("FROM UsuarioFuncionario").getResultList();
	}

}
