package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.Reparacao;
import edm.piquete.servico.ReparacaoServico;

@Service
@Transactional
public class ReparacaoServicoImpl implements ReparacaoServico{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Reparacao reparacao) {
		entityManager.merge(reparacao);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacao> listarTodas() {
		return entityManager.createQuery("from Reparacao order by nome").getResultList();
		}

	@Override
	public void excluir(Reparacao reparacao) {
		entityManager.remove(entityManager.merge(reparacao));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacao> obterReparacoesDaIstalacao(Instalacao instalacao) {
		return entityManager.createQuery("from Reparacao where instalacao = :uf order by nome")
				.setParameter("uf", instalacao).getResultList();
	} 
	
	
}
