package dgtic.core.excepcion;

public class CreditosInvalidosException extends RuntimeException {

    public CreditosInvalidosException(String mensaje) {
        super(mensaje);
    }

}
