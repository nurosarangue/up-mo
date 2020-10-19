package edm.piquete.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Avenida;
import edm.piquete.servico.AvenidaServico;

@Controller("avenidaBean")
@Scope("session")
public class AvenidaBean implements Serializable{


	private static final long serialVersionUID = -7719012227345029219L;

	private Avenida avenida;
	private List<Avenida> avenidas;
	
	@Autowired
	private AvenidaServico avenidaServico;
	
    public void iniciarBean(){
    	avenidas = avenidaServico.listarTodas();
	
}

    public void novaAvenida(){
    	avenida = new Avenida();
    }
    
	public void  salvar(){
		avenidaServico.salvar(avenida);
		avenidas = avenidaServico.listarTodas();
		avenida = null;
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Avenida Salvo com Sucesso"));
	}
	public void editar(Avenida avenida){
		this.avenida = avenida;
		
	}
	
	
	/*public void apagar(){
		bairoServico.apagar(avariaExclusao);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("participacao excluida"));
		avarias = new AvariaDAO().listarTodos();
		avariasFiltradas = null;
		}
	*/
	public void voltar(){
		avenida = null;
	}

	public Avenida getAvenida() {
		return avenida;
	}

	public void setAvenida(Avenida avenida) {
		this.avenida = avenida;
	}

	public List<Avenida> getAvenidas() {
		return avenidas;
	}

	public void setAvenidas(List<Avenida> avenidas) {
		this.avenidas = avenidas;
	}

	
	
	
}