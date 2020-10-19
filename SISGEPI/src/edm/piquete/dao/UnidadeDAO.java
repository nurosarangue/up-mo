package edm.piquete.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edm.piquete.modelo.Unidade;
import edm.piquete.modelo.Zona;

public class UnidadeDAO {

	@SuppressWarnings("unchecked")
	public static List<Unidade> obterUnidadesDaZona(Zona zona){
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Unidade> unidades = em.createQuery("from Unidade where zona = :us")
				.setParameter("us", zona).getResultList();
		
		em.close();
		
		return unidades;
	}
}
