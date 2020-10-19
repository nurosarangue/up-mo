package edm.piquete.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Estado;

public class PopulaCidade {
	

public static void main(String[] args) {
	
	
	
	    EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		/*Cidade cidadeZb1 = new Cidade("Quelimane", Estado.ZAMBEZIA);
		Cidade cidadeZb2 = new Cidade("Mocuba", Estado.ZAMBEZIA);
		Cidade cidadeZb3 = new Cidade("Milange", Estado.ZAMBEZIA);
		Cidade cidadeZb4 = new Cidade("Gurué", Estado.ZAMBEZIA);
		Cidade cidadeZb5 = new Cidade("Molocué", Estado.ZAMBEZIA);
		
		Cidade cidadeNp1 = new Cidade("Nampula", Estado.NAMPULA);
		Cidade cidadeNp2 = new Cidade("Nacala-Porto", Estado.NAMPULA);
		Cidade cidadeNp3 = new Cidade("Ilha de Moçambique", Estado.NAMPULA);
		Cidade cidadeNp4 = new Cidade("Namialó", Estado.NAMPULA);
		Cidade cidadeNp5 = new Cidade("Namapa", Estado.NAMPULA);*/
		
		
		/*em.persist(cidadeNp1);
		em.persist(cidadeNp2);
		em.persist(cidadeNp3);
		em.persist(cidadeNp4);
		em.persist(cidadeNp5);
		
		em.persist(cidadeZb1);
		em.persist(cidadeZb2);
		em.persist(cidadeZb3);
		em.persist(cidadeZb4);
		em.persist(cidadeZb5);*/
		
		em.getTransaction().commit();
		em.close();
		
	}

}
