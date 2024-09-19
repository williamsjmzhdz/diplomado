package unam.diplomado.notificaciones.messaging;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.extern.java.Log;
import unam.diplomado.notificaciones.domain.Notificacion;
import unam.diplomado.notificaciones.service.NotificacionService;

import java.util.logging.Level;

@Log
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName="destination", propertyValue = "java:/jms/queue/NotificacionQueue"
                ),
                @ActivationConfigProperty(
                        propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"
                )
        }
)
public class NotificacionConsumerImpl implements MessageListener {

    @Inject
    private NotificacionService notificacionService;

    @Override
    public void onMessage(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            Integer idUsuario = mapMessage.itemExists("idUsuario") ? mapMessage.getInt("idUsuario") : 0;
            String email = mapMessage.itemExists("email") ? mapMessage.getString("email") : "";
            Notificacion notificacionCreada =
                    notificacionService.enviarNotificacionAltaUsuario(idUsuario, email);
            log.info("Se procesó de manera exitosa el mensaje, notificación generada: " + notificacionCreada);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al consumir el mensaje en NotificacionConsumerImpl.");
        }
    }
}
