package unam.diplomado.pixup.usuario.domain;

public class MunicipioNotFoundException extends RuntimeException {

    public MunicipioNotFoundException(Integer id) {
        super("No se encontró el municipio con id: " + id);
    }

}
