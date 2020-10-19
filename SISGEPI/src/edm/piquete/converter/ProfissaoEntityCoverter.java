package edm.piquete.converter;

import javax.faces.convert.FacesConverter;

import edm.piquete.modelo.Profissao;
@FacesConverter("profissaoConverter")
public class ProfissaoEntityCoverter extends EntityConverter<Profissao>{

	public ProfissaoEntityCoverter() {
		super(Profissao.class);
	}

}
