package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Profissao;
import edm.piquete.servico.ProfissaoServico;

@Service(value = "profissaoServico")
@Transactional

public class ProfissaoServicoImpl implements ProfissaoServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Profissao profissao) {
		entityManager.merge(profissao);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profissao> listarTodos() {
		return entityManager.createQuery("from Profissao").getResultList();
	}

	@Override
	public void excluir(Profissao profissao) {
		profissao = entityManager.merge(profissao);
		entityManager.remove(profissao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profissao> listarProfissaoAccordion() {
		return entityManager.createQuery("from Avaria where nome in ('Nome', " +
				"'TipoProfissao') order by nome").getResultList();
	}
}
