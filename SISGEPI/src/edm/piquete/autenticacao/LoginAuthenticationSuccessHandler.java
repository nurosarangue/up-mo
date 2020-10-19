package edm.piquete.autenticacao;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication)
			throws IOException, ServletException {
		

		Set<String> permissoes = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		// TODO Auto-generated method stub
		
		if (permissoes.contains("ROLE_ADMIN")) {
		//	System.out.print("/n/n/n Nome do utilizador Logado::" + authenticationContext.getUsuarioLogado().getNome());
				response.sendRedirect(request.getContextPath() + "/admin/index.jsf");

			}
		
		    else	if (permissoes.contains("ROLE_RECEP")) {
			//	System.out.print("/n/n/n Nome do utilizador Logado::" + authenticationContext.getUsuarioLogado().getNome());
					response.sendRedirect(request.getContextPath() + "/operador/index.jsf");

				}
		
	}

}
