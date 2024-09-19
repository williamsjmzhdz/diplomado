package dgtic.core.modelo;

public class Descuento {

    private Integer porcentaje;
    private String nombre;
    private Usuario usuario;

    public Double aplicarDescuento(Double precio) {
        return (precio - (precio * (porcentaje / 100.0)));
    }

    private void validarPorcentaje(Integer porcentaje) {
        if (porcentaje == null || porcentaje < 1 || porcentaje > 100)
            throw new IllegalArgumentException("El porcentaje de descuento no debe ser nulo y debe estar en el rango de 1 a 100.");
    }

    private void validarNombre(String nombre) {
        if (nombre.length() > 40 || nombre == null)
            throw new IllegalArgumentException("El nombre del descuento no debe ser nulo ni exceder los 40 caracteres.");
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        validarPorcentaje(porcentaje);
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
