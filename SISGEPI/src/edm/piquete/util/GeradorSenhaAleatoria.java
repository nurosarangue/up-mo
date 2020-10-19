package edm.piquete.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenhaAleatoria {

	private static String caracteresSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String gerarSenhaAleatoria(int tamanhoSenha) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < tamanhoSenha; i++){
			builder.append(caracteresSenha.charAt((int) (Math.random() * 36)));
		}
		return builder.toString();
	}
	public static String criptografarSenhaUsuario(String senhaFornecida) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(senhaFornecida);
		return encodePassword;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(gerarSenhaAleatoria(4));
		System.out.println("Criptografada0: "+criptografarSenhaUsuario("Admin"));
		System.out.println("Senha Criptografada1: "+criptografarSenhaUsuario("User"));
	} 
	
}
