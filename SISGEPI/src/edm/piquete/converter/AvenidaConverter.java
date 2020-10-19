package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Avenida;


@FacesConverter("avenidaConverter")
public class AvenidaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Avenida avenida = new Avenida();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			avenida.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			avenida.setNome(propriedades[1]);
		}
		
		return avenida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Avenida)){
			return "";
		}
		
		Avenida avenida = (Avenida) obj;
		
		String id = avenida.getId() == null ? "" : avenida.getId().toString();
		String nome = avenida.getNome() == null ? "" : avenida.getNome();
		
		return id + "#" + nome;
	}

}
