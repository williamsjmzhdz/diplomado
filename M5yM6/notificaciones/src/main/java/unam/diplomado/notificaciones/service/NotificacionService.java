package unam.diplomado.notificaciones.service;

import jakarta.ejb.Local;
import unam.diplomado.notificaciones.domain.Notificacion;

@Local
public interface NotificacionService {
    Notificacion enviarNotificacionAltaUsuario(Integer idUsuario, String email);
}
