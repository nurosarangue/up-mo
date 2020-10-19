package edm.piquete.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Unidade;
import edm.piquete.modelo.Zona;
import edm.piquete.servico.UnidadeServico;

@Controller
@Scope("session")
public class UnidadeBean implements Serializable{

	private static final long serialVersionUID = 8061421737863086733L;

	private Unidade unidade = new Unidade();
	private List<Unidade> unidades;
	private Unidade unidadeSelecionada;
	
	@Autowired
	private UnidadeServico unidadeServico;
	
	public void iniciarBean(){
		
		consultar();
	}
	
	public void salvar(){
		unidadeServico.salvar(unidade);
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Unidade e Zona Cadastrada com Sucesso"));
		unidade = new Unidade();
		unidadeSelecionada = null;
		consultar();
	}
	
	public void cancelar(){
		unidade = new Unidade();
		unidadeSelecionada = null;
	}
	
	public void excluir(){
		unidadeServico.excluir(unidadeSelecionada);
		unidadeSelecionada = null;
		consultar();
		
	}
	
	public void consultar(){
		unidades = unidadeServico.listarTodas();
	}
	
	public List<Zona> getZonas(){
		return Arrays.asList(Zona.values());
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade getUnidadeSelecionada() {
		return unidadeSelecionada;
	}

	public void setUnidadeSelecionada(Unidade unidadeSelecionada) {
		this.unidadeSelecionada = unidadeSelecionada;
	}
	
	
}
