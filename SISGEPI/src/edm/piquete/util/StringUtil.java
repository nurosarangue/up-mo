package edm.piquete.util;

public class StringUtil {
	
	
	
	public static String preencherZerosAEsquerda(String valor, int quantidade){
		int zerosNecessarios = quantidade - valor.length();
		for(int i = 0; i < zerosNecessarios; i++){
			valor = "0" + valor;
		}
		
		return valor;
	}
	
	
	
	public static String pegarUltimoNome(String nome){
		int posicao=0;
		for(int i = 0;i < nome.length();i++){
			 if(nome.charAt(i) == ' ')
				 posicao = i;
			 
		}
		String no = nome.substring(posicao,nome.length());
		
		return no;
		
	}
	
	public static String pegarTresLetrasDoUltimoNome(String nome){
		int posicao=0;
		for(int i = 0;i < nome.length();i++){
			 if(nome.charAt(i) == ' ')
				 posicao = i;
			 
		}
		String no = nome.substring(posicao,nome.length());
		String nomeFinal = no.substring(0,4);
		return nomeFinal;
		
	}
	
	
	public static String pegarTresLetrasDoPrimeiroNome(String nome){
		int posicao=0;
		String nomeFinal = new String();
		for(int i = 0;i < nome.length();i++){
			 if(nome.charAt(i) == ' '){
				 posicao=i;
			 }
				
				
		}
		 
		String no = nome.substring(0,posicao);
		
			nomeFinal = no.substring(0,3);
		
		
		
		return nomeFinal;
		
	}
	
	public static String pegarPrimeirasTresLetrasDoTitulo(String nome){
		
		//String text = "The Francisco Pedro Macoo";
		String[] s =nome.trim().split(" ");
		String nomeFinal = new String();
		if (s[0].length()<=3) {
			//System.out.println("primeira Removendo 'O' :"+s[1]);
			nomeFinal = s[1].substring(0,3);
		}else{
			nomeFinal=s[0].substring(0, 3);
		}
			

		return nomeFinal;
	}
	
	
	
	public static void main(String[] args) {
		
		//experienciaBuscarUltimoNumerocandidato();
	}

}
