package dgtic.core.model.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Integer id) {
        super("No se encontró el usuario con id '" + id + "'.");
    }
}
