package edm.piquete.dao;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Unidade;
import edm.piquete.modelo.Zona;

public class PopulaZona {

public static void main(String[] args) {
		
	    EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Unidade unidade1 = new Unidade("Ruasse", Zona.GURRUE);
		Unidade unidade2 = new Unidade("Ruasse12", Zona.GURRUE);
		Unidade unidade3 = new Unidade("Ruasse321", Zona.GURRUE);
		
		Unidade unidadeU1 = new Unidade("Nante", Zona.MAGANJA);
		Unidade unidadeU2 = new Unidade("Mucubela", Zona.MAGANJA);
		Unidade unidadeU3 = new Unidade("Mucubela", Zona.MAGANJA);
		
		Unidade unidadeR1 = new Unidade("Mugema", Zona.MOLOCUE);
		Unidade unidadeR2 = new Unidade("Mugema2", Zona.MOLOCUE);
		Unidade unidadeR3 = new Unidade("Mugema3", Zona.MAGANJA);
		
		
		
		em.persist(unidade1);
		em.persist(unidade2);
		em.persist(unidade3);
		
		em.persist(unidadeU1);
		em.persist(unidadeU2);
		em.persist(unidadeU3);
		
		em.persist(unidadeR1);
		em.persist(unidadeR2);
		em.persist(unidadeR3);
		
		em.getTransaction().commit();
		em.close();
	}

}
