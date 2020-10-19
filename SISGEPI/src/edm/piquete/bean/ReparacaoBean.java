package edm.piquete.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.dao.GenericDAO;
import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.Reparacao;

@Controller
@Scope("view")
public class ReparacaoBean implements Serializable{

	
	private static final long serialVersionUID = 7434412013514975224L;

	private Reparacao reparacao = new Reparacao();
	private List<Reparacao> reparacoes;
	private Reparacao reparacaoSelecionada;

	
	
	public void iniciarBean(){
		
		consultar();
	}
	
	public void salvar(){
		new GenericDAO<Reparacao>(Reparacao.class).salvar(reparacao);
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Reparacao Cadastrada"));
		reparacao = new Reparacao();
		reparacaoSelecionada = null;
		consultar();
	}
	
	public void cancelar(){
		reparacao = new Reparacao();
		reparacaoSelecionada = null;
	}
	
	public void excluir(){
		new GenericDAO<Reparacao>(Reparacao.class).excluir(reparacaoSelecionada);
		reparacaoSelecionada = null;
		consultar();
	}
	
	public void consultar(){
		reparacoes = new GenericDAO<Reparacao>(Reparacao.class).listarTodos();
	}
	
	public List<Instalacao> getInstalacoes(){
		return Arrays.asList(Instalacao.values());
	}

	public Reparacao getReparacao() {
		return reparacao;
	}

	public void setReparacao(Reparacao reparacao) {
		this.reparacao = reparacao;
	}

	public List<Reparacao> getReparacoes() {
		return reparacoes;
	}

	public void setReparacoes(List<Reparacao> reparacoes) {
		this.reparacoes = reparacoes;
	}

	public Reparacao getReparacaoSelecionada() {
		return reparacaoSelecionada;
	}

	public void setReparacaoSelecionada(Reparacao reparacaoSelecionada) {
		this.reparacaoSelecionada = reparacaoSelecionada;
	}
	
	
}
