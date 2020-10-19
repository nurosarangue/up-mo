package edm.piquete.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.Reparacao;

public class ReparacaoDAO {

	@SuppressWarnings("unchecked")
	public static List<Reparacao> obterReparacoesDaIstalacao(Instalacao instalacao){
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Reparacao> reparacoes = em.createQuery("from Reparacao where instalacao = :ur")
				.setParameter("ur", instalacao).getResultList();
		
		em.close();
		
		return reparacoes;
	}
}
