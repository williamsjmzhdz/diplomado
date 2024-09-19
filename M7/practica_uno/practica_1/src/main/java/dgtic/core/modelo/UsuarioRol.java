package dgtic.core.modelo;

import java.time.LocalDateTime;

public class UsuarioRol {

    private LocalDateTime fechaAsignacion;
    private Usuario usuario;
    private Rol rol;

    public void asignarRol(Rol rol) {
        if (rol == null)
            throw new IllegalArgumentException("El rol no puede ser nulo.");

        this.rol = rol;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
