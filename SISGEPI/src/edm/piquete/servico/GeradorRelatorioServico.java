package edm.piquete.servico;

import java.util.Map;

public interface GeradorRelatorioServico {
	
	
	public String grarRelatorio(String caminho,Map<String, Object> parametros);
	public void gerarPdf(String caminho, Map<String, Object> parametros, String titulo);
	

	

}
