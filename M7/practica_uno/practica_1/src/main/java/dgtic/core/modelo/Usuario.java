package dgtic.core.modelo;

public class Usuario {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String contrasenia;

    public Boolean verificarCredenciales(String correoElectronico, String contrasenia) {
        return this.correoElectronico.equals(correoElectronico) && this.contrasenia.equals(contrasenia);
    }

    public String obtenerNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    private void validarNombre(String nombre) {
        if (nombre.length() > 40 || nombre == null)
            throw new IllegalArgumentException("El nombre no debe ser nulo ni exceder los 40 caracteres.");
    }

    private void validarApellido(String apellido) {
        if (apellido.length() > 40 || apellido == null)
            throw new IllegalArgumentException("Un apellido no debe ser nulo ni exceder los 40 caracteres.");
    }

    private void validarCorreoElectronico(String correoElectronico) {
        if (correoElectronico.length() > 80 || correoElectronico == null)
            throw new IllegalArgumentException("El correo no debe ser nulo ni exceder los 80 caracteres.");
    }

    private void validarContrasenia(String contrasenia) {
        if (contrasenia.length() > 40 || contrasenia == null)
            throw new IllegalArgumentException("La contraseña no debe ser nula ni exceder los 40 caracteres.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        validarApellido(apellidoPaterno);
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        validarApellido(apellidoMaterno);
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        validarCorreoElectronico(correoElectronico);
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        validarContrasenia(contrasenia);
        this.contrasenia = contrasenia;
    }
}
