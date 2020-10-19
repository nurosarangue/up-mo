package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Profissao;

@FacesConverter("profissaoConverter")
public class ProfissaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Profissao profissao  = new Profissao();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			profissao.setId(new Integer(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			profissao.setNome(propriedades[1]);
		}
		
		return profissao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Profissao)){
			return "";
		}
		
		Profissao profissao = (Profissao) obj;
		
		String id = profissao.getId() == null ? "" : profissao.getId().toString();
		String nome = profissao.getNome() == null ? "" : profissao.getNome();
		
		return id + "#" + nome;
	}
}
