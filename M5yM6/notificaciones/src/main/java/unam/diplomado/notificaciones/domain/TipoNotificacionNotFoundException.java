package unam.diplomado.notificaciones.domain;

public class TipoNotificacionNotFoundException extends RuntimeException {

    public TipoNotificacionNotFoundException(String descripcion) {
        super("No se encontró el tipo de notificacion para el evento: " + descripcion);
    }

}
