package edm.piquete.util;

import java.security.MessageDigest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeCodigo {
	private static String caractereSenha = "ABCDEFGHIJKLMNOPQRSTUVXWYZ0123456789";

	private static String numerosCodigo = "0123456789";

	public static String gerarSenhaAleatoria(int tamanhoSenha) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tamanhoSenha; i++) {
			builder.append(caractereSenha.charAt((int) (Math.random() * 36)));
		}
		return builder.toString();
	}

	public static String geradorNumeroReserva(int tamanhoCodigo) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tamanhoCodigo; i++) {
			builder.append(numerosCodigo.charAt((int) (Math.random() * 10)));
		}
		return builder.toString();
	}
	
	
	public static String gerarPreReferencia(int tamanho) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			builder.append(numerosCodigo.charAt((int) (Math.random() * 10)));
		}
		return builder.toString();
	}
	

	public static String gerarCodigoParaLoginUsuario(int tamanhoCodigo) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tamanhoCodigo; i++) {
			builder.append(numerosCodigo.charAt((int) (Math.random() * 10)));
		}
		return builder.toString();
	}

	public static String gerarCdigoSemRepeticao(int tamanho){
		StringBuilder builder = new StringBuilder();
		int[] num = new int[2];		
		geraCodigo(num, builder);
		while(builder.toString().length()<tamanho){
			builder = new StringBuilder();
			geraCodigo(num, builder);
		}
		return  builder.toString();
	}
	
	
	
	public static String gerarCodigoAleatorioSemRepeticao(int tamanho) {
		StringBuilder builder = new StringBuilder();
		int[] num = new int[2];		
		geraCodigo(num, builder);
		while(builder.toString().length()<tamanho){
			builder = new StringBuilder();
			geraCodigo(num, builder);
		}

		return builder.toString();

	}

	private static void geraCodigo(int[] num, StringBuilder builder) {
		int numero;
		Random random = new Random();
		for (int i = 0; i < num.length; i++) {
			numero = random.nextInt(60) + 1;
			geraRandom(num, numero, i, random);
		}
		for (int i = 0; i < num.length; i++) {
			builder.append(num[i]);
		}
	}	
	 
	

	public static void geraRandom(int[] num, int numero, int i, Random r) {

		for (int j = 0; j < num.length; j++) {
			if (numero == num[j] && j != i) {
				numero = r.nextInt(60) + 1;
			} else
				num[i] = numero;
		}
	}

	public static String HoraActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);
		return dataFormatada;

	}

	public static String HorExp() {
		SimpleDateFormat sdf = new SimpleDateFormat("00:15:00", Locale.getDefault());
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);
		return dataFormatada;

	}

	public static String dataActual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public static String DataMini() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	
	public static String AnoActual() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}


	private static String getDataActual() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	
	
	// ==================================================== implementacao dos metodos a cima criados==================
	public static String gerarCodigoCurso(){
		
		String codigoCurso = gerarCodigoAleatorioSemRepeticao(4);
		
		return codigoCurso;
		
	}
	
	
//Metodo para gerar o codigo do funcionario
	public static String gerarCodigoLoginFuncionario(String nomeFuncionario) {

		String CodigoGerado = gerarCodigoAleatorioSemRepeticao(4);

		String login = StringUtil.pegarTresLetrasDoUltimoNome(nomeFuncionario);
		login = login.toUpperCase().replace(" ", "");
		login = login + "." + CodigoGerado + "." + getDataActual();

		return login;

	}
	public static String criptografarEmailParaRecuperaSenha(String email){
		try {
			MessageDigest algoritimo = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algoritimo.digest(email.getBytes("UTF-8"));
			StringBuilder builder = new StringBuilder();
			for (byte b:messageDigest) {
				builder.append(String.format("%02X", 0xFF & b));
						}
			return builder.toString().toLowerCase();
		} catch (Exception e) {
		}
		return null;
	}
	

	public static String criptografarSenhaUsuario(String senhaFornecida) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(senhaFornecida);
		return encodePassword;

	}
	
	public static void main(String[] args) {
		System.out.println("Senha: SIGETCC Admin: '" + criptografarSenhaUsuario("Admin") + "'");
		System.out.println("Senha: SIGETCC Admin: '" + criptografarSenhaUsuario("User") + "'");
	}


}
