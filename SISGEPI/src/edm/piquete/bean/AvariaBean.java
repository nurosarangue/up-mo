package edm.piquete.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.dao.AvariaDAO;
import edm.piquete.modelo.AreaDestribuicao;
import edm.piquete.modelo.Avaria;
import edm.piquete.modelo.LocalBairo;
import edm.piquete.modelo.RuaAvenida;
import edm.piquete.modelo.TipoDeAvaria;
import edm.piquete.modelo.TipoEstalacao;
import edm.piquete.modelo.TurnoRecepcao;
import edm.piquete.servico.AvariaServico;
import edm.piquete.servico.GeradorRelatorioServico;
import edm.piquete.util.Mensagem;


@Controller("avariaBean")
@ManagedBean
@Scope("session")
public class AvariaBean implements Serializable{
	
	
	private static final long serialVersionUID = 839426433849289347L;
	
	private Avaria avaria;
	private List<LocalBairo> bairos;
	private List<TipoDeAvaria> tipoDeAvarias = new ArrayList<TipoDeAvaria>();
	private List<RuaAvenida> avenidas;
	private List<TipoEstalacao> estalacaos;
	private List<AreaDestribuicao> areas;
	private List<TurnoRecepcao> turnos;
	private Avaria avariaExclusao;
	public List<Avaria> avariasFiltradas;
	private boolean pesquisaBoolean;
	private String pesquisa;
	private Integer quantidaderegistos;
	private Avaria avariaSelecionada;
	private List<Avaria> avarias2=new ArrayList<>();
	
	@Autowired
    private AvariaServico avariaServico;
	@Autowired
	private GeradorRelatorioServico geradorRelatorioServico;
	
	private List<Avaria> avarias = new ArrayList<Avaria>();
	private List<Avaria> avariasAccordion = new ArrayList<Avaria>();
	
    public void iniciarBean(){
	avarias = avariaServico.listarTodos();
	bairos  = Arrays.asList(LocalBairo.values());
	
	avenidas = Arrays.asList(RuaAvenida.values());
	estalacaos = Arrays.asList(TipoEstalacao.values());
	areas = Arrays.asList(AreaDestribuicao.values());
	turnos = Arrays.asList(TurnoRecepcao.values());
	
		
}
    public void iniciar(){
    	pesquisaBoolean=false;
    	avarias=avariaServico.listarTodos();
    	avarias2=avariaServico.listarAvariasBaixadas();
    }
    
    public void pesquisarAvariaBaixadas(){
		try {
			if (pesquisa == "") {
				quantidaderegistos=0;
				avarias2 = null;
				Mensagem.mensagemAlerta("Por favor preencha o campo de pesquisa");
				return;
			} else if (pesquisa != null) {
				avarias2 = avariaServico.buscarAvariasBaixadas(pesquisa);
				if(avarias2==null){
					quantidaderegistos=0;
				}
				else if(avarias2!=null){
					quantidaderegistos=avarias2.size();
				}
				if(pesquisa==""){
					avarias2=null;
					quantidaderegistos=0;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void pesquisarAvaria(){
		try {
			if (pesquisa == "") {
				quantidaderegistos=0;
				avarias = null;
				Mensagem.mensagemAlerta("Por favor preencha o campo de pesquisa");
				return;
			} else if (pesquisa != null) {
				avarias = avariaServico.buscarAvariasPorPesquisa(pesquisa);
				if(avarias==null){
					quantidaderegistos=0;
				}
				else if(avarias!=null){
					quantidaderegistos=avarias.size();
				}
				if(pesquisa==""){
					avarias=null;
					quantidaderegistos=0;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void baixarAvaria(){
    	this.avariaSelecionada.setActiva(false);
    	this.avariaSelecionada.setDataresolucao(new Date());
    	this.avariaSelecionada.setResolvida(true);
    	avariaServico.actualizar(this.avariaSelecionada);    
    	avarias2=avariaServico.listarTodos();
    	Mensagem.mensagemInformacao("Caro funcionario! O seu registo foi salvo com sucesso");
    }
    
    public void voltarPesquisa(){
    	pesquisaBoolean=false;
    }
    public void visualizarDetalhesAvaria(Avaria avaria){
    	this.avaria=avaria;
    	pesquisaBoolean=true;
    }
    
    public void preparaExclusao(Avaria avaria){
    	this.avariaSelecionada=avaria;
    }

    public void novaAvaria(){
    	avaria = new Avaria();
    }
    
	public void  salvar() throws InterruptedException{
		Thread.sleep(1000);
		avariaServico.salvar(avaria);
		avarias = avariaServico.listarTodos();
		avaria = null;
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Avaria Participada com Sucesso"));
	}
	//public String editar
	public void editar(Avaria avaria){
		this.avaria = avaria;
		//return "Resisto_Avaria?faces-redirect=true";
		
	}
	
	public void prepararExclusao(Avaria avaria){
		this.avariaExclusao = avaria;
	}
	public void apagar(){
		avariaServico.apagar(avariaExclusao);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("participacao excluida"));
		avarias = new AvariaDAO().listarTodos();
		avariasFiltradas = null;
		}
	
	public void voltar(){
		avaria = null;
	}
	
	
	public void imprimirDadosAvaria(Avaria avaria){
		this.avaria = avaria;				
		String titulo = this.avaria.getCliente().getNome()+".pdf";
		String caminho = "/Relatorio/avaria/avaria.jasper";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCliente", this.avaria.getCliente().getId());
		System.out.println("Cliente encontrado: "+this.avaria.getCliente().getNome());
		geradorRelatorioServico.gerarPdf(caminho, parametros, titulo);
	}
	
     public String getDataActual(){
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public Avaria getAvaria() {
		return avaria;
	}

	public void setAvaria(Avaria avaria) {
		this.avaria = avaria;
	}

	public List<LocalBairo> getBairos() {
		return bairos;
	}

	public void setBairos(List<LocalBairo> bairos) {
		this.bairos = bairos;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}




	public List<RuaAvenida> getAvenidas() {
		return avenidas;
	}

	public void setAvenidas(List<RuaAvenida> avenidas) {
		this.avenidas = avenidas;
	}

	public List<TipoEstalacao> getEstalacaos() {
		return estalacaos;
	}

	public void setEstalacaos(List<TipoEstalacao> estalacaos) {
		this.estalacaos = estalacaos;
	}

	public List<TurnoRecepcao> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<TurnoRecepcao> turnos) {
		this.turnos = turnos;
	}
	public List<AreaDestribuicao> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaDestribuicao> areas) {
		this.areas = areas;
	}
	public List<Avaria> getAvariasAccordion() {
		return avariasAccordion;
	}
	public void setAvariasAccordion(List<Avaria> avariasAccordion) {
		this.avariasAccordion = avariasAccordion;
	}

	public Avaria getAvariaExclusao() {
		return avariaExclusao;
	}

	public void setAvariaExclusao(Avaria avariaExclusao) {
		this.avariaExclusao = avariaExclusao;
	}

	public List<Avaria> getAvariasFiltradas() {
		return avariasFiltradas;
	}

	public void setAvariasFiltradas(List<Avaria> avariasFiltradas) {
		this.avariasFiltradas = avariasFiltradas;
	}
	public boolean isPesquisaBoolean() {
		return pesquisaBoolean;
	}
	public void setPesquisaBoolean(boolean pesquisaBoolean) {
		this.pesquisaBoolean = pesquisaBoolean;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	public Integer getQuantidaderegistos() {
		return quantidaderegistos;
	}
	public void setQuantidaderegistos(Integer quantidaderegistos) {
		this.quantidaderegistos = quantidaderegistos;
	}
	public List<TipoDeAvaria> getTipoDeAvarias() {
		return tipoDeAvarias;
	}
	public void setTipoDeAvarias(List<TipoDeAvaria> tipoDeAvarias) {
		this.tipoDeAvarias = tipoDeAvarias;
	}
	public Avaria getAvariaSelecionada() {
		return avariaSelecionada;
	}
	public void setAvariaSelecionada(Avaria avariaSelecionada) {
		this.avariaSelecionada = avariaSelecionada;
	}
	public List<Avaria> getAvarias2() {
		return avarias2;
	}
	public void setAvarias2(List<Avaria> avarias2) {
		this.avarias2 = avarias2;
	}
	
	
	
}
