package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.TipoDeAvaria;

@FacesConverter("tipoAvariaConverter")
public class TipoAvariaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		TipoDeAvaria tipoDeAvaria = new TipoDeAvaria();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			tipoDeAvaria.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			tipoDeAvaria.setDescricao(propriedades[1]);
		}
		
		return tipoDeAvaria;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof TipoDeAvaria)){
			return "";
		}
		
		TipoDeAvaria tipoDeAvaria = (TipoDeAvaria) obj;
		
		String id = tipoDeAvaria.getId() == null ? "" : tipoDeAvaria.getId().toString();
		String nome = tipoDeAvaria.getDescricao() == null ? "" : tipoDeAvaria.getDescricao();
		
		return id + "#" + nome;
	}


}
