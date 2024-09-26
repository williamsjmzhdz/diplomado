package dgtic.core.model.exception;

public class MetodoPagoAlreadyExistsException extends RuntimeException {
    public MetodoPagoAlreadyExistsException(String numeroTarjeta) {
        super("El método de pago con número de tarjeta '" + numeroTarjeta + "' ya existe.");
    }
}
