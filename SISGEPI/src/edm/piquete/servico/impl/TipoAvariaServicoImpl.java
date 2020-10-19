package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.TipoDeAvaria;
import edm.piquete.servico.TipoAvariaServico;
@Service("tipoAvariaServico")
@Transactional
public class TipoAvariaServicoImpl implements TipoAvariaServico{

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public void salvar(TipoDeAvaria tipoDeAvaria) {
		em.merge(tipoDeAvaria);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDeAvaria> listarTodas() {
		List<TipoDeAvaria> list= em.createQuery("from TipoDeAvaria").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
