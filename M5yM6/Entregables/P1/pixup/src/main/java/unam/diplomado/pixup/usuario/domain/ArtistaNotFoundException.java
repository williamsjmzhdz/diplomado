package unam.diplomado.pixup.usuario.domain;

public class ArtistaNotFoundException extends RuntimeException {

    public ArtistaNotFoundException(Integer id) {
        super("No se encontró el/la artista con id: " + id);
    }

}
