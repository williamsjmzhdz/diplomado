package unam.diplomado.notificaciones.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.notificaciones.domain.Notificacion;
import unam.diplomado.notificaciones.domain.TipoNotificacion;
import unam.diplomado.notificaciones.domain.TipoNotificacionNotFoundException;
import unam.diplomado.notificaciones.repository.NotificacionRepository;
import unam.diplomado.notificaciones.repository.TipoNotificacionRepository;
import unam.diplomado.pixup.usuario.domain.TipoDomicilioNotFoundException;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.domain.UsuarioNotFoundException;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

public class NotificacionServiceImpl implements NotificacionService {

    @Inject
    private TipoNotificacionRepository tipoNotificacionRepository;
    @Inject
    private NotificacionRepository notificacionRepository;
    @Inject
    private EmailService emailService;
    @Inject
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Notificacion enviarNotificacionAltaUsuario(Integer idUsuario, String email) {

        String descTipoNotificacion = "ALTA_USUARIO";
        String emailTitulo = "Creación de cuenta " + email + " exitosa.";
        String emailMensaje = "<h1>Pixup</h1><h3>" + "La cuenta " + email + " fue creada exitosamente</h3>";

        // Validación existencia previa usuario
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNotFoundException(email);
        }

        // Validación existencia tipo notificación
        Optional<TipoNotificacion> tipoNotificacion =
                tipoNotificacionRepository.findByDescripcion(descTipoNotificacion);
        if (tipoNotificacion.isEmpty()) {
            throw new TipoNotificacionNotFoundException(descTipoNotificacion);
        }

        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(usuario.get());
        notificacion.setTipoNotificacion(tipoNotificacion.get());
        notificacionRepository.save(notificacion);

        emailService.enviarEmail(email, emailTitulo, emailMensaje);

        return notificacion;
    }
}
