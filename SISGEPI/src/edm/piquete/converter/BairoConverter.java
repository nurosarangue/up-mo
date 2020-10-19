package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Bairo;

@FacesConverter("bairoConverter")
public class BairoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Bairo bairo = new Bairo();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			bairo.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			bairo.setNome(propriedades[1]);
		}
		
		return bairo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Bairo)){
			return "";
		}
		
		Bairo bairo = (Bairo) obj;
		
		String id = bairo.getId() == null ? "" : bairo.getId().toString();
		String nome = bairo.getNome() == null ? "" : bairo.getNome();
		
		return id + "#" + nome;
	}

}
