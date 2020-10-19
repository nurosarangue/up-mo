package edm.piquete.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.Bairo;
import edm.piquete.servico.BairoServico;

@Controller("bairoBean")
@Scope("session")
public class BairoBean implements Serializable{

	private static final long serialVersionUID = -1605513486494630543L;

	private Bairo bairo;
	private List<Bairo> bairos;
	
	@Autowired
	private BairoServico bairoServico;
	
    public void iniciarBean(){
	bairos = bairoServico.listarTodos();
	
		
}

    public void novoBairo(){
    	bairo = new Bairo();
    }
    
	public void  salvar(){
		bairoServico.salvar(bairo);
		bairos = bairoServico.listarTodos();
		bairo = null;
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Bairo Salvo com Sucesso"));
	}
	public void editar(Bairo bairo){
		this.bairo = bairo;
		
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
		bairo = null;
	}

	public Bairo getBairo() {
		return bairo;
	}

	public void setBairo(Bairo bairo) {
		this.bairo = bairo;
	}

	public List<Bairo> getBairos() {
		return bairos;
	}

	public void setBairos(List<Bairo> bairos) {
		this.bairos = bairos;
	}
	
	
}