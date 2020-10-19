package edm.piquete.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.exception.LoginRepetidoException;
import edm.piquete.modelo.Avaria;
import edm.piquete.modelo.Usuario;
import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.AvariaServico;
import edm.piquete.servico.UsuarioFuncionarioServico;
import edm.piquete.servico.UsuarioServico;
import edm.piquete.util.Mensagem;

@Controller
@Scope("session")
@ManagedBean
public class UsuarioFuncionarioBean implements Serializable {

	private static final long serialVersionUID = -9042726092407566514L;

	private UsuarioFuncionario usuarioFuncionario;
	private List<UsuarioFuncionario> usuariosFuncionario;
	private List<Usuario> usuarios;
	private List<Avaria> avarias;

	@Autowired
	private UsuarioFuncionarioServico usuarioFuncionarioServico;

	@Autowired
	private UsuarioServico usuarioServico;

	@Autowired
	private AvariaServico avariaServico;

	public void iniciarBean() {
		actualizarListaUsuarios();
		usuarios = usuarioServico.listarTodos();
		avarias = avariaServico.listarTodos();
	}

	public void novoUsuarioFuncionario() {
		usuarioFuncionario = new UsuarioFuncionario();
	}

	public void salvar() {
		try {
			usuarioFuncionarioServico.salvar(usuarioFuncionario);
			actualizarListaUsuarios();
			usuarioFuncionario = null;
			Mensagem.mensagemInformacao("Usuário salvo com sucesso");
		} catch (LoginRepetidoException e) {
			Mensagem.mensagemErro(e.getMessage());
		}
	}

	public void editar(UsuarioFuncionario usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}

	public void cancelar() {
		this.usuarioFuncionario = null;
	}

	private void actualizarListaUsuarios() {
		usuariosFuncionario = usuarioFuncionarioServico.listarTodos();
	}

	public UsuarioFuncionario getUsuarioFuncionario() {
		return usuarioFuncionario;
	}

	public void setUsuarioFuncionario(UsuarioFuncionario usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}

	public List<UsuarioFuncionario> getUsuariosFuncionario() {
		return usuariosFuncionario;
	}

	public void setUsuariosFuncionario(List<UsuarioFuncionario> usuariosFuncionario) {
		this.usuariosFuncionario = usuariosFuncionario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

}
