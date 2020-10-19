package edm.piquete.dao;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.Reparacao;


public class PopulaReparacao {

public static void main(String[] args) {
		
	    EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Reparacao reparacao1 = new Reparacao("Nao tem uz", Instalacao.TRI);
		Reparacao reparacao2 = new Reparacao("Contador Queimado", Instalacao.MONO);
		Reparacao reparacao3 = new Reparacao("Contador Queimado", Instalacao.BI);
			
		em.persist(reparacao1);
		em.persist(reparacao2);
		em.persist(reparacao3);

		em.getTransaction().commit();
		em.close();
	}


}
