package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Bairo;

@FacesConverter("bairoCoverter")
public class BairoEntityCoverter extends EntityConverter<Bairo>{

	public BairoEntityCoverter() {
		super(Bairo.class);
	}

}
