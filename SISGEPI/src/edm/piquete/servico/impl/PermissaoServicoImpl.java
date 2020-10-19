package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Permissao;
import edm.piquete.servico.PermissaoServico;
@Service("permissaoServico")
@Transactional
public class PermissaoServicoImpl implements PermissaoServico{

@PersistenceContext
	private EntityManager em;
	@Override
	public void salvar(Permissao permissao) {
		em.merge(permissao);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permissao> listarTodas() {
		List<Permissao> list=em.createQuery("FROM Permissao").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
