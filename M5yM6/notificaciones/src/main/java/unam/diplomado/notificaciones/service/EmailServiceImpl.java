package unam.diplomado.notificaciones.service;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;

@Stateless
public class EmailServiceImpl implements EmailService {

    @Resource(mappedName = "java:jboss/mail/Default")
    private Session mailSession;

    @Override
    public void enviarEmail(String email, String titulo, String mensaje) {
        try {
            // Crear email
            MimeMessage message = new MimeMessage(mailSession);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
            message.setSubject(titulo);
            message.setContent(mensaje, "text/html");
            message.setSentDate(new Date());

            // Enviar email
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailServerUnavailableException("Email Service");
        }
    }

}
