package edm.piquete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.exception.LoginRepetidoException;
import edm.piquete.modelo.Usuario;
import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.UsuarioFuncionarioServico;
import edm.piquete.servico.UsuarioServico;
import edm.piquete.util.Mensagem;

@Controller("equipeDragDropBean")
@Scope("session")
public class equipeDragDropBean implements Serializable{

	private static final long serialVersionUID = 2080404434345627386L;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosInseridos = new ArrayList<Usuario>();
	private List<UsuarioFuncionario> usuariosFuncionario;
	private List<Usuario> funcionariosInseridos = new ArrayList<Usuario>();
	
	@Autowired
	private UsuarioServico usuarioServico;
	@Autowired
	private UsuarioFuncionarioServico usuarioFuncionarioServico;
	
	public void iniciarBean() {
		actualizarListaUsuarios();
		usuarios = usuarioServico.listarTodos();
		usuariosFuncionario = usuarioFuncionarioServico.listarTodosActivos();
		
	}
	
/*	public void onUsuarioDrop(DragDropEvent event){
	UsuarioFuncionario usuarioFuncionario = (UsuarioFuncionario) event.getData();
	usuariosFuncionario.remove(usuarioFuncionario);
	funcionariosInseridos.add(usuarioFuncionario);
}*/
	
	public void onUsuarioDrop(DragDropEvent event){
	   Usuario usuario = (Usuario) event.getData();	
	   usuarios.remove(usuario);
	   usuariosInseridos.add(usuario);
	}

	public void novoUsuario() {
		usuario = new Usuario();
	}

	public void salvar() {
		try {
			usuarioServico.salvar(usuario);
			actualizarListaUsuarios();
			usuario = null;
			Mensagem.mensagemInformacao("Usuário salvo com sucesso");
		} catch (LoginRepetidoException e) {
			Mensagem.mensagemErro(e.getMessage());
		}
	}

	public void editar(Usuario usuario) {
		this.usuario = usuario;
	}

	public void cancelar() {
		this.usuario = null;
	}

	private void actualizarListaUsuarios() {
		usuariosFuncionario = usuarioFuncionarioServico.listarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<UsuarioFuncionario> getUsuariosFuncionario() {
		return usuariosFuncionario;
	}

	public void setUsuariosFuncionario(List<UsuarioFuncionario> usuariosFuncionario) {
		this.usuariosFuncionario = usuariosFuncionario;
	}

	public List<Usuario> getUsuariosInseridos() {
		return usuariosInseridos;
	}

	public void setUsuariosInseridos(List<Usuario> usuariosInseridos) {
		this.usuariosInseridos = usuariosInseridos;
	}

	public List<Usuario> getFuncionariosInseridos() {
		return funcionariosInseridos;
	}

	public void setFuncionariosInseridos(List<Usuario> funcionariosInseridos) {
		this.funcionariosInseridos = funcionariosInseridos;
	}

	
}