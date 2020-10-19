package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Funcionario;
import edm.piquete.servico.FuncionarioServico;

@Service("funcionarioServico")
@Transactional
public class FuncionarioServicoImpl implements FuncionarioServico{

	@PersistenceContext
	private EntityManager em;
	@Override
	public void salvar(Funcionario funcionario) {
		em.merge(funcionario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> ListarTodas() {
		List<Funcionario> list=em.createQuery("From Funcionario").getResultList();
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Funcionario buscarFuncionarioexistente(String email, String nome, String numeroFuncionario) {
		List<Funcionario> list=em.createQuery("FROM Funcionario f WHERE f.nome=:nome"
				+ " OR f.email=:email OR f.numeroFuncionario=:numeroFuncionario")
				.setParameter("nome", nome)
				.setParameter("email", email)
				.setParameter("numeroFuncionario", numeroFuncionario)
				.getResultList();
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> obterFuncionarioPorPesquisa(String pesquisa) {
		List<Funcionario> list=em.createQuery("FROM Funcionario f WHERE (f.nome"
				+ " LIKE '%"+pesquisa+"%' OR f.email LIKE '%"+pesquisa+"%'"
						+ " OR f.numeroFuncionario LIKE '%"+pesquisa+"%')"
								+ " AND f.activo=true ").getResultList();
		
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
