package mx.unam.dgtic.exception;

import java.time.LocalDateTime;

public class DetalleError {

    private String statusCode;
    private String mensaje;
    private String detalle;
    private LocalDateTime timeStamp;

    public DetalleError() {
    }

    public DetalleError(String statusCode, String mensaje, String detalle, LocalDateTime timeStamp) {
        this.statusCode = statusCode;
        this.mensaje = mensaje;
        this.detalle = detalle;
        this.timeStamp = timeStamp;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
