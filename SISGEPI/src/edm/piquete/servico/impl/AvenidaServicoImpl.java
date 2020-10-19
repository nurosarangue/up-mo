package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Avenida;
import edm.piquete.servico.AvenidaServico;

@Service(value = "avenidaServico")
@Transactional
public class AvenidaServicoImpl implements AvenidaServico{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void salvar(Avenida avenida) {
		entityManager.merge(avenida);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avenida> listarTodas() {
		return entityManager.createQuery("from Avenida").getResultList();
	}

	@Override
	public void excluir(Avenida avenida) {
		avenida = entityManager.merge(avenida);
		entityManager.remove(avenida);
		
	}

}
