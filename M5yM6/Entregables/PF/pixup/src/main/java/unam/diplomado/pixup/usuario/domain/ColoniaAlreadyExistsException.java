package unam.diplomado.pixup.usuario.domain;

public class ColoniaAlreadyExistsException extends RuntimeException {

    public ColoniaAlreadyExistsException(String cp, String nombre) {
        super("Ya existe la colonia con cp: " + cp + " y nombre: " + nombre);
    }

}
