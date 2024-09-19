package unam.diplomado.pixup.usuario.domain;

public class TipoDomicilioNotFoundException extends RuntimeException {

    public TipoDomicilioNotFoundException(Integer id) {
        super("No se encontró el tipo de domicilio con id: " + id);
    }

}
