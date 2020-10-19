package edm.piquete.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Profissao;

public class ProfissaoDAO {
	
	public void salvar(Profissao profissao){
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(profissao);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
@SuppressWarnings("unchecked")
public List<Profissao>listarTodos(){
	
	EntityManager entityManager = JPAUtil.getEntityManager();
	
	return entityManager.createQuery("from Profissao").getResultList();
	
	
}
public void apagar(Profissao profissao) {
	EntityManager entityManager = JPAUtil.getEntityManager();
	
	entityManager.getTransaction().begin();
	
	profissao = entityManager.merge(profissao);
	
	
	entityManager.remove(profissao);
	
	entityManager.getTransaction().commit();
	
	entityManager.close();
	
}

@SuppressWarnings("unchecked")
public static List<Profissao> listarProfissoesAccordion() {
EntityManager entityManager = JPAUtil.getEntityManager();
	
	return entityManager.createQuery("from Profissao where nome in ('Nome', " +
				"'TipoProfissao') order by nome").getResultList();
	}

}
