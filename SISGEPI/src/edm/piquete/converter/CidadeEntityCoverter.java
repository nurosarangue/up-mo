package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Cidade;
@FacesConverter("cidadeEntityCoverter")
public class CidadeEntityCoverter extends EntityConverter<Cidade>{

	public CidadeEntityCoverter() {
		super(Cidade.class);
	}

}
