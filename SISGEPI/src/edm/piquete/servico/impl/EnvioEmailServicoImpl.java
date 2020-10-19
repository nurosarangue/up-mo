package edm.piquete.servico.impl;

import java.io.File;
import java.util.List;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import edm.piquete.modelo.UsuarioFuncionario;
import edm.piquete.servico.EnvioEmailServico;

@Service
public class EnvioEmailServicoImpl implements EnvioEmailServico{

	@Override
	//@Scheduled(fixedDelay = 5000)
	public void enviarEmail(String assunto, String texto, 
			List<File> anexos, String... destinatarios) {
		
		try {
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setProtocol("smtp");
			mailSender.setUsername("samuelsarangue85@gmail.com");
			mailSender.setPassword("Sarangue07");
			mailSender.setDefaultEncoding("utf-8");
			
			Properties properties = new Properties();
			properties.setProperty("username", "samuelsarangue85@gmail.com");
			properties.setProperty("password", "Sarangue07");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.transport.protocol", "smtp");
			mailSender.setJavaMailProperties(properties);
			
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, false);
			helper.setFrom("samuelsarangue85@gmail.com");
			helper.setSubject(assunto);
			helper.setText(texto, true);
			//helper.addTo("samuelsarangue85@gmail.com");
			
			for (String destinatario : destinatarios) {
				helper.addTo(destinatario);
			}
			
			mailSender.send(msg);
			
			System.out.println("Enviando Email.....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@Async
	public void enviarEmailCadastroUsuarioFuncinario(
			UsuarioFuncionario usuarioFuncionario, String senha) {

		String assunto = "Cadastro de Usuario";
		String texto = pegarHtmlEmail(
				"resources/email_cadastro_usuario_funcionario.html");
		texto = texto.replace("{funcionario.nome}", usuarioFuncionario.getNome());
		texto = texto.replace("{funcionario.login}", usuarioFuncionario.getLogin());
		texto = texto.replace("{funcionario.senha}", senha);
		
		enviarEmail(assunto, texto, null, usuarioFuncionario.getEmail());
	}
	

	private String pegarHtmlEmail(String url) {
		InputStream is = getClass().getResourceAsStream(url);
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result;
		try {
			result = bis.read();
			while (result != -1) {
				byte b = (byte) result;
				buf.write(b);
				result = bis.read();
			}
			return buf.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
