package unam.diplomado.pixup.usuario.messaging;

public interface NotificacionProducer {
    boolean enviarNotificacionAltaUsuario(Integer idUsuario, String email);
}
