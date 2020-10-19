package edm.piquete.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Avaria;

public class AvariaDAO {
	
	
	
	
	public void salvar(Avaria avaria){
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(avaria);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}
@SuppressWarnings("unchecked")
public static  List<Avaria>listarTodos(){
	
	EntityManager entityManager = JPAUtil.getEntityManager();
	
	return entityManager.createQuery("from Avaria").getResultList();
	
	
}
public void apagar(Avaria avaria) {
	EntityManager entityManager = JPAUtil.getEntityManager();
	
	entityManager.getTransaction().begin();
	
	avaria = entityManager.merge(avaria);
	
	
	entityManager.remove(avaria);
	
	entityManager.getTransaction().commit();
	
	entityManager.close();
	
}
@SuppressWarnings("unchecked")
public static List<Avaria> listarAvariasAccordion() {
EntityManager entityManager = JPAUtil.getEntityManager();
	
	return entityManager.createQuery("from Avaria where nome in ('Particpar', " +
				"'Reclamacao') order by nome").getResultList();
	}


}
