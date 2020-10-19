package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Unidade;
import edm.piquete.modelo.Zona;
import edm.piquete.servico.UnidadeServico;

@Service
@Transactional
public class UnidadeServicoImpl implements UnidadeServico{

	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void salvar(Unidade unidade) {
		entityManager.merge(unidade);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade> listarTodas() {
		return entityManager.createQuery("from Unidade order by nome").getResultList();
	}

	@Override
	public void excluir(Unidade unidade) {
		entityManager.remove(entityManager.merge(unidade));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade> obterUnidadesDaZona(Zona zona) {
		return entityManager.createQuery("from Unidade where zona = :uf order by nome")
				.setParameter("uf", zona).getResultList();
	}

	

}
