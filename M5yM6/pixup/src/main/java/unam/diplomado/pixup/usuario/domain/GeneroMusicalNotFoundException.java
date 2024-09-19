package unam.diplomado.pixup.usuario.domain;

public class GeneroMusicalNotFoundException extends RuntimeException {

    public GeneroMusicalNotFoundException(Integer id) {
        super("No se encontró el género músical con id: " + id);
    }

}
