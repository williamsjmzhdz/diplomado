package unam.diplomado.notificaciones.repository;

import unam.diplomado.notificaciones.domain.Notificacion;

public interface NotificacionRepository {

    Notificacion save(Notificacion notificacion);

}