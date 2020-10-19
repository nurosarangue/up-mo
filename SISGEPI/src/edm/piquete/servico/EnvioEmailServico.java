package edm.piquete.servico;

import java.io.File;
import java.util.List;

import edm.piquete.modelo.UsuarioFuncionario;

public interface EnvioEmailServico {

	public void enviarEmail(String assunto, String texto, 
			List<File> anexos, String... destinatarios);
	
	public void enviarEmailCadastroUsuarioFuncinario(
		UsuarioFuncionario usuarioFuncionario, String senha);
}
