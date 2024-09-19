package unam.diplomado.pixup.usuario.domain;

public class DisqueraNotFoundException extends RuntimeException {

    public DisqueraNotFoundException(Integer id) {
        super("No se encontró la disquera con id: " + id);
    }

}
