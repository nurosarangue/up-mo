package edm.piquete.servico.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edm.piquete.servico.GeradorRelatorioServico;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
@Transactional
public class GeradorRelatorioServicoImpl implements GeradorRelatorioServico {

	@PersistenceContext
	private EntityManager em;

	private static class myWork implements Work {
		Connection conetion;

		@Override
		public void execute(Connection value) throws SQLException {
			this.conetion = value;

		}

		Connection getConnection() {
			return conetion;
		}

	}

	private Connection conexao() {
		Session session = em.unwrap(Session.class);
		myWork work = new myWork();
		session.doWork(work);
		return work.getConnection();
	}

	@Override
	public String grarRelatorio(String caminho, Map<String, Object> parametros) {
		String relatorio = null;
		try {
			relatorio = JasperFillManager.fillReportToFile(caminho, parametros, conexao());
		} catch (JRException e) {

			e.printStackTrace();
		}
		return relatorio;
	}

	@Override
	public void gerarPdf(String caminho, Map<String, Object> parametros, String titulo) {

		try {

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			ServletOutputStream servletOutputStream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment;filename=" + titulo);
			context.responseComplete();
			ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
			String caminhoReal = servletContext.getRealPath(caminho);
			byte[] bytes = JasperRunManager.runReportToPdf(caminhoReal, parametros, conexao());
			servletOutputStream.write(bytes, 0, bytes.length);

			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
