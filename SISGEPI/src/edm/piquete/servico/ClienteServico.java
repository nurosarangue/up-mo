package edm.piquete.servico;

import java.util.List;

import edm.piquete.modelo.Cidade;
import edm.piquete.modelo.Cliente;
import edm.piquete.modelo.ParametrosBuscaCliente;
import edm.piquete.modelo.Provincia;

public interface ClienteServico {

	public void salvar(Cliente cliente);
	public List<Cliente> listarTodos();
	public List<Cliente> pesquisar(ParametrosBuscaCliente parametros);
	public List<Cliente> buscarClientePorParametro(Integer pesquisa);
	public List<Cliente> buscarClientePorPesquisa(String pesquisa);
	public List<Cidade> buscarCidadesDaProvincia(Long id);
	public List<Provincia> listarProvincias();
	public Cliente obterClienteExistenteBanco(String nome, Integer contador);
	
}
