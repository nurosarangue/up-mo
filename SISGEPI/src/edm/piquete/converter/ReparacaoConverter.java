package edm.piquete.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Reparacao;


@FacesConverter("reparacaoConverter")
public class ReparacaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
	}
		
		Reparacao reparacao = new Reparacao();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			reparacao.setId(new Integer(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			reparacao.setNome(propriedades[1]);
		}
		
		return reparacao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Reparacao)){
			return "";
	}
		Reparacao reparacao = (Reparacao) obj;
		
		String id = reparacao.getId() == null ? "" : reparacao.getId().toString();
		String nome = reparacao.getNome() == null ? "" : reparacao.getNome();
		
		return id + "#" + nome;
	}

}
