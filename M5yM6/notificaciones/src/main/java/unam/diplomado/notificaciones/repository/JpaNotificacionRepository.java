package unam.diplomado.notificaciones.repository;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.notificaciones.domain.Notificacion;

import java.util.Date;

@Singleton
public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Notificacion save(Notificacion notificacion) {
        notificacion.setFechaNotificacion(new Date((System.currentTimeMillis())));
        entityManager.persist(notificacion);
        return notificacion;
    }

}
