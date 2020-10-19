package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Avaria;
@FacesConverter("avariaCoverter")
public class AvariaEntityCoverter extends EntityConverter<Avaria>{

	public AvariaEntityCoverter() {
		super(Avaria.class);
	}

}
