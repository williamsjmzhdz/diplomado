package dgtic.core.modelo;

public class Rol {

    private String nombre;
    private String descripcion;

    public String obtenerDescripcionCompleta() {
        return nombre + ": " + descripcion;
    }

    private void validarNombre(String nombre) {
        if (nombre.length() > 20 || nombre == null)
            throw new IllegalArgumentException("El nombre del rol no debe ser nulo ni exceder los 20 caracteres.");
    }

    private void validarDescripcion(String descripcion) {
        if (descripcion.length() > 100 || descripcion == null)
            throw new IllegalArgumentException("La descripción del rol no debe ser nulo ni exceder los 100 caracteres.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        validarDescripcion(descripcion);
        this.descripcion = descripcion;
    }
}
