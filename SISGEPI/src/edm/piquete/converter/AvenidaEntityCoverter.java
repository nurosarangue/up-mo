package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Avenida;
@FacesConverter("avenidaCoverter")
public class AvenidaEntityCoverter extends EntityConverter<Avenida>{

	public AvenidaEntityCoverter() {
		super(Avenida.class);
	}

}
