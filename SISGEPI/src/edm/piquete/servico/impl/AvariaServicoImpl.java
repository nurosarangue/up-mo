package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Avaria;
import edm.piquete.modelo.Cliente;
import edm.piquete.servico.AvariaServico;

@Service(value = "avariaServico")
@Transactional
public class AvariaServicoImpl implements AvariaServico{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void salvar(Avaria avaria) {
		entityManager.merge(avaria);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avaria> listarTodos() {
		List<Avaria> list= entityManager.createQuery("from Avaria where activa=true").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	@Override
	public void apagar(Avaria avaria) {
		avaria = entityManager.merge(avaria);
		entityManager.remove(avaria);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avaria> listarAvariasAccordion() {
		return entityManager.createQuery("from Avaria where nome in ('Particpar', " +
				"'Reclamacao') order by nome").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avaria> buscarAvariasPorPesquisa(String pesquisa) {
		List<Avaria> list = entityManager.createQuery("FROM Avaria a WHERE "
				+ "(a.cliente.nome LIKE '%"+pesquisa+"%' OR a.cliente.contador "
						+ "LIKE '%"+pesquisa+"%' OR a.cliente.telefone LIKE '%"+pesquisa+"%') and activa=true").getResultList();
		if(!list.isEmpty()){
			return list;
		}	
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Avaria> buscarAvariasBaixadas(String pesquisa) {
		List<Avaria> list = entityManager.createQuery("FROM Avaria a WHERE "
				+ "(a.cliente.nome LIKE '%"+pesquisa+"%' OR a.cliente.contador "
						+ "LIKE '%"+pesquisa+"%' OR a.cliente.telefone LIKE '%"+pesquisa+"%') and resolvida=true").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avaria> listarAvariasBaixadas() {
	List<Avaria> list = entityManager.createQuery("From Avaria where resolvida=true").getResultList();
	if(!list.isEmpty()){
		return list;
	}
	return null;
	}

	@Override
	public void actualizar(Avaria avariaSelecionada) {
		entityManager.merge(avariaSelecionada);
		
	}

}
