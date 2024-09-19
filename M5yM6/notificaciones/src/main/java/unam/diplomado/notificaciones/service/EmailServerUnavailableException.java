package unam.diplomado.notificaciones.service;

public class EmailServerUnavailableException extends RuntimeException {
    public EmailServerUnavailableException(String servicio) {
        super("El servicio de " + servicio + " no se encuentra disponible.");
    }
}
