package unam.diplomado.pixup.usuario.domain;

public class ColoniaNotFoundException extends RuntimeException {

    public ColoniaNotFoundException(Integer id) {
        super("No se encontró la colonia con id: " + id);
    }

}
