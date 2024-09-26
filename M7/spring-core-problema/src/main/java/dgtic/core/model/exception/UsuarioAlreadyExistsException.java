package dgtic.core.model.exception;

public class UsuarioAlreadyExistsException extends RuntimeException {
    public UsuarioAlreadyExistsException(String correoElectronico) {
        super("El usuario con correo electrónico '" + correoElectronico + "' ya existe.");
    }
}
