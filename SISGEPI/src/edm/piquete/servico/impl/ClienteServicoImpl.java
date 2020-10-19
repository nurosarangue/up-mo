package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Cliente;
import edm.piquete.modelo.ParametrosBuscaCliente;
import edm.piquete.modelo.Provincia;
import edm.piquete.servico.ClienteServico;

@Service("clienteServico")
@Transactional
public class ClienteServicoImpl implements ClienteServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Cliente cliente) {
		entityManager.merge(cliente);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarTodos() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	public List<Cliente> pesquisar(ParametrosBuscaCliente parametros) {
        StringBuilder builder = new StringBuilder("select new edm.piquete.modelo("+
    			"c.id, c.nome, c.contador, c.telefone, c.referencia, c.dataParticipar, c.endereco, c.bairo.nome) from Cliente c where c.id is not null");
        
        
        if(parametros.getCliente() != null){
        	builder.append(" end c.cliente = :cliente");
        }
        
        if(parametros.getBairos() != null && !parametros.getBairos().isEmpty()){
        	builder.append(" end c.bairo in (:bairos)");
        }
		
        Query query = entityManager.createQuery(builder.toString());
       
        if(parametros.getCliente() != null){
        	query.setParameter("cliente", parametros.getCliente());
        }
        
        if(parametros.getBairos() != null && !parametros.getBairos().isEmpty()){
             query.setParameter("bairos", parametros.getBairos());
        }
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientePorParametro(Integer pesquisa) {
	List<Cliente> list = entityManager.createQuery("FROM Cliente WHERE contador=:pesquisa").setParameter("pesquisa", pesquisa).getResultList();
	if(!list.isEmpty()){
		return list;
	}	
	return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarClientePorPesquisa(String pesquisa) {
		List<Cliente> list = entityManager.createQuery("FROM Cliente c WHERE "
				+ "(c.nome LIKE '%"+pesquisa+"%' OR c.contador "
						+ "LIKE '%"+pesquisa+"%' OR c.telefone LIKE '%"+pesquisa+"%')").getResultList();
		if(!list.isEmpty()){
			return list;
		}	
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscarCidadesDaProvincia(Long id) {
		List<Cidade> list = entityManager.createQuery("FROM Cidade WHERE provincia.id=:id").setParameter("id", id).getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Provincia> listarProvincias() {
		List<Provincia> list=entityManager.createQuery("FROM Provincia").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente obterClienteExistenteBanco(String nome, Integer contador) {
		List<Cliente> list=entityManager.createQuery("FROM Cliente c WHERE"
				+ " c.nome =:nome OR "
				+ "c.contador=:contador")
				.setParameter("nome", nome)
				.setParameter("contador", contador)
				.getResultList();
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
