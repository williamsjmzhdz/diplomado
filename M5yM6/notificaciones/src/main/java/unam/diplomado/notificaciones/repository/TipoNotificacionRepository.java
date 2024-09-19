package unam.diplomado.notificaciones.repository;

import unam.diplomado.notificaciones.domain.TipoNotificacion;

import java.util.Optional;

public interface TipoNotificacionRepository {

    Optional<TipoNotificacion> findByDescripcion(String descripcion);

}