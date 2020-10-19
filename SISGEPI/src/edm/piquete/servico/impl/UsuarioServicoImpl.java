package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.modelo.Usuario;
import edm.piquete.servico.UsuarioServico;
@Service("usuarioServico")
@Transactional
public class UsuarioServicoImpl implements UsuarioServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario obterUsuarioPeloLogin(String login) {
		List<Usuario> usuarios = entityManager.createQuery(
				"from Usuario where login = :login")
				.setParameter("login", login)
				.getResultList();
		
		if(usuarios.isEmpty()){
			return null;
		}
		return usuarios.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarTodos() {
		return entityManager.createQuery("FROM Usuario").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarTodosActivos() {
		return entityManager.createQuery("FROM Usuario WHERE activo=true").getResultList();
	}

	@Override
	public void salvar(Usuario usuario) {
		entityManager.merge(usuario);
		
	}
	public String criptografarSenhaUsuario(String senhaFornecida) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(senhaFornecida);
		return encodePassword;
	}
	public boolean verificarSenhaDigitada(String senhaFornecida, String senhaBanco) {
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder.matches(senhaFornecida, senhaBanco);
	}

}
