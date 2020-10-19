package edm.piquete.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.exception.LoginRepetidoException;
import edm.piquete.modelo.Usuario;
import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.EnvioEmailServico;
import edm.piquete.servico.UsuarioFuncionarioServico;
import edm.piquete.servico.UsuarioServico;
import edm.piquete.util.GeradorSenhaAleatoria;

@Service
@Transactional
public class UsuarioFuncionarioServicoImpl implements UsuarioFuncionarioServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UsuarioServico usuarioServico;


	
	@Autowired
	private EnvioEmailServico  envioEmailServico;
	
	@Override
	public void salvar(UsuarioFuncionario usuarioFuncionario) {
		usuarioFuncionario.setLogin(usuarioFuncionario.getEmail());
		Usuario usuarioSalvo = usuarioServico.obterUsuarioPeloLogin(usuarioFuncionario.getLogin());
		if(usuarioSalvo != null && !usuarioSalvo.getLogin().equals(usuarioFuncionario.getId())){
			throw new LoginRepetidoException("J� existe um usu�rio cadastrado com este email");
		}
		
		if(usuarioFuncionario.getId() == null){
			String senhaGerada = GeradorSenhaAleatoria.gerarSenhaAleatoria(6);
			System.out.println(senhaGerada);
			//String senhaCriptografada = passwordEncoder.encodePassword(senhaGerada, null);
			String senhaCriptografada =usuarioServico.criptografarSenhaUsuario(senhaGerada);
			usuarioFuncionario.setSenha(senhaCriptografada);
			envioEmailServico.enviarEmailCadastroUsuarioFuncinario(usuarioFuncionario, senhaGerada);
			//TODO - Enviar Email com login e senha
		}
		entityManager.merge(usuarioFuncionario);
	}

	@Override
	public List<UsuarioFuncionario> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioFuncionario> listarTodosActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
