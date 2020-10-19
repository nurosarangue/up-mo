package edm.piquete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Avaria;
import edm.piquete.modelo.Cliente;
import edm.piquete.modelo.TipoDeAvaria;
import edm.piquete.servico.AvariaServico;
import edm.piquete.servico.ClienteServico;
import edm.piquete.servico.TipoAvariaServico;
import edm.piquete.util.Mensagem;
import sun.invoke.empty.Empty;


@ManagedBean
@Controller("registarAvariasBean")
@Scope("session")
public class RegistarAvariasBean implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6207586621199443645L;
	private boolean painelGroup1;
	private boolean painelGroup2;
	private boolean painelGroup3;
	private boolean painelGroup4;
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Cliente> listaClientes=new ArrayList<Cliente>();
	private Integer pesquisa;
	private Cliente clienteSelecionado;
	private Avaria avaria = new Avaria();
	private List<TipoDeAvaria> tipoDeAvarias = new ArrayList<TipoDeAvaria>();
	@Autowired
	private ClienteServico clienteServico;
	@Autowired
	private TipoAvariaServico tipoAvariaServico;
	@Autowired
	private AvariaServico avariaServico;
	
	
	
	
	public void iniciarBean(){
		painelGroup1=false;
		painelGroup2=false;
		painelGroup3=false;
		painelGroup4=false;
		clientes=null;
		
		
	}
	
	public void buscarCliente(){
		listaClientes=clienteServico.buscarClientePorParametro(pesquisa);
		if(listaClientes==null){
			Mensagem.mensagemErro("Nenhum registo encontrado com o numero inserido! Tente novamente");
		}else if(listaClientes!=null){
			clientes=listaClientes;
		}
	}
	
	public void seguintePrencherForm(Cliente cliente){
		this.clienteSelecionado=cliente;
	tipoDeAvarias=	tipoAvariaServico.listarTodas();
		painelGroup1=true;
		painelGroup2=true;
		painelGroup3=false;
		painelGroup4=false;
	}
	
	public void salvar(){
		avaria.setActiva(true);
		avaria.setCliente(clienteSelecionado);
		avaria.setDataCadastro(new Date());
		avariaServico.salvar(avaria);
		
		if(avaria.getId()==null){
			Mensagem.mensagemInformacao("Registo salvo com sucesso");
		}else{
			Mensagem.mensagemInformacao("Registo actualizado com sucesso");
		}
		clienteSelecionado=null;
		avaria=new Avaria();
		pesquisa=null;
		clientes=null;
		painelGroup1=false;
		painelGroup2=false;
		
	}
	public boolean isPainelGroup1() {
		return painelGroup1;
	}
	public void setPainelGroup1(boolean painelGroup1) {
		this.painelGroup1 = painelGroup1;
	}
	public boolean isPainelGroup2() {
		return painelGroup2;
	}
	public void setPainelGroup2(boolean painelGroup2) {
		this.painelGroup2 = painelGroup2;
	}
	public boolean isPainelGroup3() {
		return painelGroup3;
	}
	public void setPainelGroup3(boolean painelGroup3) {
		this.painelGroup3 = painelGroup3;
	}
	public boolean isPainelGroup4() {
		return painelGroup4;
	}
	public void setPainelGroup4(boolean painelGroup4) {
		this.painelGroup4 = painelGroup4;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Integer getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(Integer pesquisa) {
		this.pesquisa = pesquisa;
	}
	public ClienteServico getClienteServico() {
		return clienteServico;
	}
	public void setClienteServico(ClienteServico clienteServico) {
		this.clienteServico = clienteServico;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Avaria getAvaria() {
		return avaria;
	}

	public void setAvaria(Avaria avaria) {
		this.avaria = avaria;
	}

	public List<TipoDeAvaria> getTipoDeAvarias() {
		return tipoDeAvarias;
	}

	public void setTipoDeAvarias(List<TipoDeAvaria> tipoDeAvarias) {
		this.tipoDeAvarias = tipoDeAvarias;
	}
	
	
	

}
