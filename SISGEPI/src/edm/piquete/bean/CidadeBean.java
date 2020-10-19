package edm.piquete.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Estado;
import edm.piquete.servico.CidadeServico;

@Controller
@Scope("session") 
public class CidadeBean implements Serializable{

	private static final long serialVersionUID = 6578442178318315433L;
	
	private Cidade cidade = new Cidade();
	private List<Cidade> cidades;
	private Cidade cidadeSelecionada;
	
	@Autowired
	private CidadeServico cidadeServico;
	
	public List<Estado> getEstados(){
		return Arrays.asList(Estado.values());
	}
	
	public void iniciarBean() {
		consultar();
	}

	public void salvar(){
		cidadeServico.salvar(cidade);
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Delegação Cadastrada com Sucesso"));
		cidade = new Cidade();
		cidadeSelecionada = null;
		consultar();
		//RequestContext.getCurrentInstance().execute("PF('cadastroCidadeDialog').hide()");
	}
	
	public void cancelar(){
		cidade = new Cidade();
		cidadeSelecionada = null;
	}
	
	public void excluir(){
		cidadeServico.excluir(cidadeSelecionada);
		cidadeSelecionada = null;
		consultar();
	}

	public void consultar(){
		cidades = cidadeServico.listarTodas();
		
	}
	
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
	
	
}
