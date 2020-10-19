package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Bairo;
import edm.piquete.servico.BairoServico;

@Service(value = "bairoServico")
@Transactional
public class BairoServicoImpl implements BairoServico{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void salvar(Bairo bairo) {
		entityManager.merge(bairo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bairo> listarTodos() {
		return entityManager.createQuery("from Bairo").getResultList();
	}

	@Override
	public void excluir(Bairo bairo) {
		bairo = entityManager.merge(bairo);
		entityManager.remove(bairo);
		
	}

}
