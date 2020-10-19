package edm.piquete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Avenida;
import edm.piquete.modelo.Bairo;
import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Cliente;
import edm.piquete.modelo.Estado;
import edm.piquete.modelo.Funcionario;
import edm.piquete.modelo.Instalacao;
import edm.piquete.modelo.ParametrosBuscaCliente;
import edm.piquete.modelo.Provincia;
import edm.piquete.modelo.Zona;
import edm.piquete.servico.AvenidaServico;
import edm.piquete.servico.BairoServico;
import edm.piquete.servico.CidadeServico;
import edm.piquete.servico.ClienteServico;
import edm.piquete.servico.GeradorRelatorioServico;
import edm.piquete.util.Mensagem;


@Controller("clienteBean")
@ManagedBean
@Scope("session")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 3444561497674109084L;

	private Cliente cliente;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Estado> estados;
	private Provincia provincia = new Provincia();
	private List<Provincia> provincias = new ArrayList<Provincia>();
	private List<Zona> zonas;
	private List<Cidade> cidades;
	private List<Bairo> bairos;
	private List<Avenida> avenidas;
	private List<Instalacao> instalacoes;
	private ParametrosBuscaCliente parametros = new ParametrosBuscaCliente();
	private boolean cadastroBoolean;
	private boolean novoCadastroBoolean;
	private String pesquisa;
	private Integer quantidadeRegistos;
	private Cliente clienteSelecionado;

	@Autowired
	private ClienteServico clienteServico;
	
	@Autowired
	private CidadeServico cidadeServico;
	
	@Autowired
	private BairoServico bairoServico;
	
	@Autowired
	private AvenidaServico avenidaServico;
	@Autowired
	private GeradorRelatorioServico geradorRelatorioServico;
	
	
	
	public void iniciarBean() {
		clientes = clienteServico.listarTodos();
		estados = Arrays.asList(Estado.values());
		zonas = Arrays.asList(Zona.values());
		cidades =cidadeServico.listarTodas();
		instalacoes = Arrays.asList(Instalacao.values());
		bairos = bairoServico.listarTodos();
		avenidas = avenidaServico.listarTodas();
	}
	
	public void iniciar(){
		cadastroBoolean=false;
		novoCadastroBoolean=false;
		cliente=new Cliente();
		clientes=null;
		provincias=null;
	}
	public void iniciarOperadorBean(){
		cadastroBoolean=false;
		
	}
	public void visualizarClienteOperador(Cliente cliente){
		this.clienteSelecionado=cliente;
		cadastroBoolean=true;
		provincias=clienteServico.listarProvincias();
		cidades =cidadeServico.listarTodas();
		
	}
	
	public void novoRegisto(){
		cadastroBoolean=true;
		novoCadastroBoolean=true;
		cliente=new Cliente();
		estados = Arrays.asList(Estado.values());
		zonas = Arrays.asList(Zona.values());
		cidades =cidadeServico.listarTodas();
		instalacoes = Arrays.asList(Instalacao.values());
		bairos = bairoServico.listarTodos();
		avenidas = avenidaServico.listarTodas();
		provincias=clienteServico.listarProvincias();
	}
	
	public void voltarPesquisa(){
		pesquisa= new String();
		cadastroBoolean=false;
		novoCadastroBoolean=false;
		cliente=new Cliente();
		provincias=null;
		pesquisa=null;
		clientes=null;
	}
	public void pesquisarCliente(){
		try {
			if (pesquisa == "") {
				quantidadeRegistos=0;
				clientes = null;
				Mensagem.mensagemAlerta("Por favor preencha o campo de pesquisa");
				return;
			} else if (pesquisa != null) {
				clientes = clienteServico.buscarClientePorPesquisa(pesquisa);
				if(clientes==null){
					quantidadeRegistos=0;
				}
				else if(clientes!=null){
				quantidadeRegistos=clientes.size();
				}
				if(pesquisa==""){
					clientes=null;
					quantidadeRegistos=0;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void imprimirDadosCliente(Cliente cliente){
		this.cliente = cliente;				
		String titulo = this.cliente.getNome()+".pdf";
		String caminho = "/Relatorio/cliente/ciente.jasper";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCliente", this.cliente.getId());
		geradorRelatorioServico.gerarPdf(caminho, parametros, titulo);
	}
	
	
	public void prepararExclusao(Cliente cliente){
		this.clienteSelecionado=cliente;
		
	}
	public void pesquisar(){
		clientes = clienteServico.pesquisar(parametros);
	}
	
	public void novoCliente() {

		cliente = new Cliente();
	}

	public void salvar() {
		Cliente clienteExistente=clienteServico.obterClienteExistenteBanco(cliente.getNome(),cliente.getContador());
		if(clienteExistente !=null && clienteExistente.getId()!=cliente.getId()){
			Mensagem.mensagemAlerta("Ops! Ja existe um cliente registado com os mesmos dados");
			return;
		}
		
		cliente.setActivo(true);
		cliente.setDataParticipar(new Date());
		clienteServico.salvar(cliente);
		if(cliente.getId()==null){
			Mensagem.mensagemInformacao("Caro Utilizador! O seu registo salvo com sucesso");
			voltarPesquisa();
		}else{
			Mensagem.mensagemInformacao("Caro Utilizador! O seu registo actualizado com sucesso");
			voltarPesquisa();
		}
		
      

	}
	
	public void voltar() {
		this.cliente = null;
	}

	public void editar(Cliente cliente) {
		this.cliente = cliente;
		cadastroBoolean=false;
		novoCadastroBoolean=true;
		provincias=clienteServico.listarProvincias();
		cidades =cidadeServico.listarTodas();
		instalacoes = Arrays.asList(Instalacao.values());
		
		
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public List<Cidade> getCidades() {
	cidades=clienteServico.buscarCidadesDaProvincia(provincia.getId());
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Instalacao> getInstalacoes() {
		return instalacoes;
	}

	public void setInstalacoes(List<Instalacao> instalacoes) {
		this.instalacoes = instalacoes;
	}

	public List<Bairo> getBairos() {
		return bairos;
	}

	public void setBairos(List<Bairo> bairos) {
		this.bairos = bairos;
	}

	public List<Avenida> getAvenidas() {
		return avenidas;
	}

	public void setAvenidas(List<Avenida> avenidas) {
		this.avenidas = avenidas;
	}

	public ParametrosBuscaCliente getParametros() {
		return parametros;
	}

	public void setParametros(ParametrosBuscaCliente parametros) {
		this.parametros = parametros;
	}

	public boolean isCadastroBoolean() {
		return cadastroBoolean;
	}

	public void setCadastroBoolean(boolean cadastroBoolean) {
		this.cadastroBoolean = cadastroBoolean;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Integer getQuantidadeRegistos() {
		return quantidadeRegistos;
	}

	public void setQuantidadeRegistos(Integer quantidadeRegistos) {
		this.quantidadeRegistos = quantidadeRegistos;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public boolean isNovoCadastroBoolean() {
		return novoCadastroBoolean;
	}

	public void setNovoCadastroBoolean(boolean novoCadastroBoolean) {
		this.novoCadastroBoolean = novoCadastroBoolean;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	

}
