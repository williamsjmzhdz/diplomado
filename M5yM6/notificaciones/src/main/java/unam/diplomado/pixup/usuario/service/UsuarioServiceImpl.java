package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.messaging.NotificacionProducer;
import unam.diplomado.pixup.usuario.repository.DomicilioRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    private ColoniaService coloniaService;
    @Inject
    private NotificacionProducer notificacionProducer;


    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        // Validación usuario duplicado
        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }

        // Validación existencia colonia
        Colonia colonia =
                coloniaService.obtenerColoniaPorId(domicilio.getColonia().getId());
        domicilio.setColonia(colonia);

        // Validación existencia tipoDomicilio
        Optional<TipoDomicilio> tipoDomicilio =
                tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if (tipoDomicilio.isEmpty()) {
            throw new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilio.get());

        // Persistencia/guardado entidades
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        // Envío notificación
        notificacionProducer.enviarNotificacionAltaUsuario(usuario.getId(), usuario.getEmail());

        return usuario;
    }

}
