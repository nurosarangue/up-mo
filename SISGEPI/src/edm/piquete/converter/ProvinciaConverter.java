package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Provincia;

@FacesConverter("provinciaConverter")
public class ProvinciaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Provincia provincia = new Provincia();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			provincia.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			provincia.setNome(propriedades[1]);
		}
		
		return provincia;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Provincia)){
			return "";
		}
		
		Provincia provincia = (Provincia) obj;
		
		String id = provincia.getId() == null ? "" : provincia.getId().toString();
		String nome = provincia.getNome() == null ? "" : provincia.getNome();
		
		return id + "#" + nome;
	}

}
