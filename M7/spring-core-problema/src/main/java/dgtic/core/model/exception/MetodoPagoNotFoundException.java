package dgtic.core.model.exception;

public class MetodoPagoNotFoundException extends RuntimeException {
    public MetodoPagoNotFoundException(Integer id) {
        super("No se encontró un método de pago con el id '" + id + "'.");
    }
}
