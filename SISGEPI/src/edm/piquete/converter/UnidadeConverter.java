package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Unidade;

@FacesConverter("unidadeConverter")
public class UnidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Unidade unidade = new Unidade();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			unidade.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			unidade.setNome(propriedades[1]);
		}
		
		return unidade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Unidade)){
			return "";
		}
		
		Unidade unidade = (Unidade) obj;
		
		String id = unidade.getId() == null ? "" : unidade.getId().toString();
		String nome = unidade.getNome() == null ? "" : unidade.getNome();
		
		return id + "#" + nome;
	}

}