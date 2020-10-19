package edm.piquete.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import edm.piquete.modelo.Usuario;
import edm.piquete.servico.UsuarioServico;


public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UsuarioServico usuarioServico;

	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken) authentication;
		String loginFornecido = userToken.getName();
		String senhaFornecida = (String) userToken.getCredentials();

		verificarPreenchimentoLoginESenha(loginFornecido, senhaFornecida);
		Usuario details = usuarioServico.obterUsuarioPeloLogin(loginFornecido);
		verificarLoginESenha(senhaFornecida, details);
		
		return new UsernamePasswordAuthenticationToken(details, senhaFornecida, details.getAuthorities());
	}

	private void verificarLoginESenha(String senhaFornecida, Usuario details) {
		if (details == null) {
			throw new BadCredentialsException("Login e/ou senha invalidos");
		}
		
		if (!usuarioServico.verificarSenhaDigitada(senhaFornecida, details.getPassword())) {
			throw new BadCredentialsException("Usuario e/ou senha Invalido");
		}

	}
	
	private void verificarPreenchimentoLoginESenha(String loginFornecido, String senhaFornecida) {
		if (loginFornecido == null || loginFornecido.trim().equals("")
				|| senhaFornecida == null
				|| senhaFornecida.trim().equals(""))
			throw new BadCredentialsException(
					"Os campos login e senha sao obrigatorios");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
