package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.UsuarioFuncionario;


@FacesConverter("usuariofuncConverter")
public class UserFuncConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		UsuarioFuncionario usuarioFuncionario = new UsuarioFuncionario();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			usuarioFuncionario.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			usuarioFuncionario.setNome(propriedades[1]);
		}
		
		return usuarioFuncionario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof UsuarioFuncionario)){
			return "";
		}
		
		UsuarioFuncionario usuarioFuncionario = (UsuarioFuncionario) obj;
		
		String id = usuarioFuncionario.getId() == null ? "" : usuarioFuncionario.getId().toString();
		String nome = usuarioFuncionario.getNome() == null ? "" : usuarioFuncionario.getNome();
		
		return id + "#" + nome;
	}

}
