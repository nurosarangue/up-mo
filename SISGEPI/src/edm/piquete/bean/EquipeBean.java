package edm.piquete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Avaria;
import edm.piquete.modelo.DiaSemana;
import edm.piquete.modelo.Equipe;
import edm.piquete.modelo.Horario;
import edm.piquete.modelo.Semestre;
import edm.piquete.modelo.Usuario;
import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.AvariaServico;
import edm.piquete.servico.EquipeServico;
import edm.piquete.servico.HorarioServico;
import edm.piquete.servico.UsuarioFuncionarioServico;
import edm.piquete.servico.UsuarioServico;
import edm.piquete.util.Mensagem;

@Controller("equipeBean")
@Scope("session")
@ManagedBean
public class EquipeBean implements Serializable {

	private static final long serialVersionUID = 1343441974816750379L;

	private Equipe equipe;
	private List<Equipe> equipes;
	private List<Usuario> usuarios;
	private List<Semestre> semestres;
	private List<Avaria> avarias;
	private List<UsuarioFuncionario> usuariosFuncionario;
	private Horario horario = new Horario();
	private int indiceHorario;
	
	@Autowired
	private EquipeServico equipeServico;
	@Autowired
	private UsuarioServico usuarioServico;
	@Autowired
	private UsuarioFuncionarioServico usuarioFuncionarioServico;
	@Autowired
	private AvariaServico avariaServico;
	@Autowired
	private HorarioServico horarioServico;
	
	public void iniciarBean(){
		semestres = Arrays.asList(Semestre.values());
		actualizarEquipes();
		usuariosFuncionario = usuarioFuncionarioServico.listarTodosActivos();
		avarias = avariaServico.listarTodos();
		usuarios = usuarioServico.listarTodosActivos();
	}

	public void novaEquipe(){
		equipe = new Equipe();
	}
	
	public void salvarEquipe(){
		equipeServico.salvar(equipe);
		equipe = null;
	    actualizarEquipes();
		Mensagem.mensagemInformacao("Equipe salvo com Sucesso");
	}
	
	public void editarEqipe(Equipe equipe){
		this.equipe = equipe;
		
	}
	
	public void cancelrEqipe(){
		this.equipe = null;
	}
	
	private void actualizarEquipes(){
		equipes = equipeServico.listarTodas();
	}
	
	
	//Horario
	public void novoHorario(){
		this.horario = new Horario();
	}
	
	public List<DiaSemana> getDiasSemana(){
		return Arrays.asList(DiaSemana.values());
	}
	
	public void limparHorario(){
		this.horario = new Horario();
	}
	
	public void salvarHorario(){
		horario = horarioServico.salvar(horario);
		
			horario = new Horario();
			Mensagem.mensagemInformacao("Horario adiciodado com sucesso");
	}
		
	
	public void editarHorario(Horario horario){
		this.horario = horario;
	}
	
	public void excluirHorario(){
		
		horario = new Horario();
		Mensagem.mensagemInformacao("Hor�rio removido com Sucesso");
	}
	
	
	
	public void prepararRemocaoHorario(int indiceHorario){
		this.indiceHorario = indiceHorario;
	}
	
	
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
}
