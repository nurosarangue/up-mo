package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Usuario;

@FacesConverter("usuarioConverter")
public class usuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Usuario usuario = new Usuario();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			usuario.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			usuario.setNome(propriedades[1]);
		}
		
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Usuario)){
			return "";
		}
		
		Usuario usuario = (Usuario) obj;
		
		String id = usuario.getId() == null ? "" : usuario.getId().toString();
		String nome = usuario.getNome() == null ? "" : usuario.getNome();
		
		return id + "#" + nome;
	}

}
