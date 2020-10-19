package edm.piquete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Funcionario;
import edm.piquete.modelo.Permissao;
import edm.piquete.modelo.Usuario;
import edm.piquete.servico.FuncionarioServico;
import edm.piquete.servico.GeradorRelatorioServico;
import edm.piquete.servico.PermissaoServico;
import edm.piquete.servico.UsuarioServico;
import edm.piquete.util.GeradorDeCodigo;
import edm.piquete.util.Mensagem;
@ManagedBean
@Controller
public class FuncionarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 867605951132679024L;
	
	private Funcionario funcionario=new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private Funcionario funcionarioSelecionado;
	private Permissao permissao;
	private List<Permissao> permissaos = new ArrayList<Permissao>();
	private boolean cadastroBoolean;
	private boolean novoCadastroBoolean;
	private String pesquisa;
	private int quantidadeRegistos;
	private Permissao permissaoSelecionada;
	@Autowired
	private FuncionarioServico funcionarioServico;
	@Autowired
	private UsuarioServico usuarioServico;
	@Autowired
	private PermissaoServico permissaoServico;
	@Autowired
	private GeradorRelatorioServico geradorRelatorioServico;
	
	
	public void iniciarBean(){
		cadastroBoolean=false;
		novoCadastroBoolean=false;
		funcionario=new Funcionario();
		pesquisa=null;
		permissaoSelecionada=null;
		
	}
	public void novoFuncionario(){
		funcionario=new Funcionario();
		cadastroBoolean=true;
		novoCadastroBoolean=true;
	}
	
	
	public void salvar(){
		Funcionario funcionarioExistente=funcionarioServico.buscarFuncionarioexistente(funcionario.getEmail(),funcionario.getNome(),funcionario.getNumeroFuncionario());
		if (funcionarioExistente != null && funcionarioExistente.getId() != funcionario.getId()) {
			Mensagem.mensagemAlerta("Ops: Ja existe um funcionario registado com os mesmos dados");
			return;
		}
	//	funcionario.setActivo(true);
		System.out.println("Permissao selecionada: "+permissaoSelecionada.getTitulo());
		funcionario.getPermissoes().add(permissaoSelecionada);
		funcionario.setDataCadastro(new Date());
		criarCodigoFuncionario();
		funcionarioServico.salvar(funcionario);
		if (funcionario.getId() == null) {
			Mensagem.mensagemInformacao("Parabens: O registo foi salvo com sucesso");
		} else {
			Mensagem.mensagemInformacao("Parabens: O registo foi actualizado com sucesso");
		}
		funcionario=new Funcionario();
		permissaoSelecionada=null;
		novoCadastroBoolean=false;
		cadastroBoolean=false;
	}
	
	public void editar(Funcionario funcionario){
		this.funcionario=funcionario;
		novoCadastroBoolean=true;
		cadastroBoolean=true;
	}
	
	
	
	
	public void pesquisar() {
		try {
			if (pesquisa == "") {
				quantidadeRegistos = 0;
				funcionarios = null;
				Mensagem.mensagemAlerta("Por favor preencha o campo de pesquisa");
				return;
			} else if (pesquisa != null) {
				funcionarios = funcionarioServico.obterFuncionarioPorPesquisa(pesquisa);
				if (funcionarios != null) {
					quantidadeRegistos = funcionarios.size();				
				}

				if (pesquisa == "") {
					funcionarios = null;
					quantidadeRegistos = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void criarCodigoFuncionario() {

		if (!funcionario.getNome().isEmpty()) {
			String login = null;
			login = GeradorDeCodigo.gerarCodigoLoginFuncionario(funcionario.getNome());
			Usuario usuario = usuarioServico.obterUsuarioPeloLogin(login);
			while (usuario != null) {
				login = null;
				login = GeradorDeCodigo.gerarCodigoLoginFuncionario(funcionario.getNome());
				usuario = usuarioServico.obterUsuarioPeloLogin(login);
			}
			if (funcionario.getLogin() == null) {
				funcionario.setLogin(login);
				funcionario.setNumeroFuncionario(login);
			} else {
				funcionario.setLogin(funcionario.getNumeroFuncionario());
				;
			}

			System.out.println("Login do funcionario: " + login);
			if (funcionario.getSenha() == null) {
				String senhaCriptografada = null;
				senhaCriptografada = usuarioServico.criptografarSenhaUsuario(login);
				funcionario.setSenha(senhaCriptografada);
			}
		}
		funcionario.setActivo(true);

	}
	
	
	public void imprimirDadosFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;				
		String titulo = this.funcionario.getNome()+".pdf";
		String caminho = "/Relatorio/funcionario/funcionario.jasper";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idUsuario", this.funcionario.getId());
		geradorRelatorioServico.gerarPdf(caminho, parametros, titulo);
	}
	
	public void listarPermissoes(){
		permissaos=permissaoServico.listarTodas();
	}
	
	public void selecionarPermissao(Permissao permissao){
		this.permissaoSelecionada=permissao;
	}

	public void prepararExclusao(Funcionario funcionario){
		this.funcionarioSelecionado=funcionario;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public List<Permissao> getPermissaos() {
		return permissaos;
	}
	public void setPermissaos(List<Permissao> permissaos) {
		this.permissaos = permissaos;
	}
	public boolean isCadastroBoolean() {
		return cadastroBoolean;
	}
	public void setCadastroBoolean(boolean cadastroBoolean) {
		this.cadastroBoolean = cadastroBoolean;
	}
	public boolean isNovoCadastroBoolean() {
		return novoCadastroBoolean;
	}
	public void setNovoCadastroBoolean(boolean novoCadastroBoolean) {
		this.novoCadastroBoolean = novoCadastroBoolean;
	}


	public String getPesquisa() {
		return pesquisa;
	}


	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public int getQuantidadeRegistos() {
		return quantidadeRegistos;
	}

	public void setQuantidadeRegistos(int quantidadeRegistos) {
		this.quantidadeRegistos = quantidadeRegistos;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Permissao getPermissaoSelecionada() {
		return permissaoSelecionada;
	}

	public void setPermissaoSelecionada(Permissao permissaoSelecionada) {
		this.permissaoSelecionada = permissaoSelecionada;
	}

}
