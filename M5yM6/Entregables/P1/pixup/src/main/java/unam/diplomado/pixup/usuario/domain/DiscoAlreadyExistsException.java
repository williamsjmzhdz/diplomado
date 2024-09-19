package unam.diplomado.pixup.usuario.domain;

public class DiscoAlreadyExistsException extends RuntimeException {

    public DiscoAlreadyExistsException(String titulo, Integer artistaId) {
        super("Ya existe el disco con título: " + titulo + " y artista con id: " + artistaId);
    }

}
