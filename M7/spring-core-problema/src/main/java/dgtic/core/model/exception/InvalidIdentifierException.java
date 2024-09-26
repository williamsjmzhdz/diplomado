package dgtic.core.model.exception;

public class InvalidIdentifierException extends RuntimeException {
    public InvalidIdentifierException(Integer id) {
        super("El id '" + id + "' no es válido.");
    }
}
