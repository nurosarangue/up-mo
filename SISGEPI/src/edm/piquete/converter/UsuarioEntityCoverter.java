package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Usuario;
@FacesConverter("usuarioCoverter")
public class UsuarioEntityCoverter extends EntityConverter<Usuario>{

	public UsuarioEntityCoverter() {
		super(Usuario.class);
	}

}
