package edm.piquete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Cliente;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		Cliente cliente = new Cliente();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			cliente.setId(new Long(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			cliente.setNome(propriedades[1]);
		}
		
		return cliente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Cliente)){
			return "";
		}
		
		Cliente cliente = (Cliente) obj;
		
		String id = cliente.getId() == null ? "" : cliente.getId().toString();
		String nome = cliente.getNome() == null ? "" : cliente.getNome();
		
		return id + "#" + nome;
	}

}
