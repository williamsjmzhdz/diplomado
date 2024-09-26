package dgtic.core.service.impl;

import dgtic.core.model.Usuario;
import dgtic.core.model.exception.InvalidIdentifierException;
import dgtic.core.model.exception.UsuarioAlreadyExistsException;
import dgtic.core.model.exception.UsuarioNotFoundException;
import dgtic.core.repository.UsuarioRepository;
import dgtic.core.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void guardar(Usuario usuario) {
        String correoElectronico = usuario.getCorreoElectronico();
        if (usuarioRepository.encontrarPorCorreoElectronico(correoElectronico).isPresent())
            throw new UsuarioAlreadyExistsException(correoElectronico);
        usuarioRepository.guardar(usuario);
    }

    @Override
    public Usuario encontrarPorId(Integer id) {
        if (id < 1) throw new InvalidIdentifierException(id);
        Optional<Usuario> optionalUsuario = usuarioRepository.encontrarPorId(id);
        if (optionalUsuario.isEmpty()) throw new UsuarioNotFoundException(id);
        return optionalUsuario.get();
    }

    @Override
    public void actualizar(Usuario usuario) {
        Integer id = usuario.getId();
        if (id < 1) throw new InvalidIdentifierException(id);
        if (usuarioRepository.encontrarPorId(id).isEmpty()) throw new UsuarioNotFoundException(id);
        usuarioRepository.actualizar(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        if (id < 1) throw new InvalidIdentifierException(id);
        if (usuarioRepository.encontrarPorId(id).isEmpty()) throw new UsuarioNotFoundException(id);
        usuarioRepository.eliminar(id);
    }

    @Override
    public List<Usuario> encontrarTodos() {
        return usuarioRepository.encontrarTodos();
    }

}
