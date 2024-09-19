package unam.diplomado.pixup.usuario.domain;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String email) {
        super("El usuario con email " + email + " no existe.");
    }
}
