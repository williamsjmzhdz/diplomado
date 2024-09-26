package dgtic.core.model.exception;

public class InvalidCardNumberException extends RuntimeException {
    public InvalidCardNumberException(String numeroTarjeta) {
        super("El número de tarjeta '" + numeroTarjeta + "' es inválido. El número de tarjeta debe tener 16 dígitos.");
    }
}
