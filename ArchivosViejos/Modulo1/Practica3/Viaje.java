/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 31/05/2025
 * Descripción: Clase Viaje de la práctica 3
 */

public class Viaje {
    private int identificador;
    private Cliente cliente;
    private Asociado chofer;
    private String fechaHoraInicio;
    private String fechaHoraFinal;
    private Double precio;
    private Double calificacion;

    public void Viaje() {
        setIdentificador(0);
        setCliente(null);
        setChofer(null);
        setFechaHoraInicio("");
        setFechaHoraFinal("");
        setPrecio(0.0);
        setCalificacion(0.0);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if(identificador >= 0) {
            this.identificador = identificador;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asociado getChofer() {
        return chofer;
    }

    public void setChofer(Asociado chofer) {
        this.chofer = chofer;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFinal() {
        return fechaHoraFinal;
    }

    public void setFechaHoraFinal(String fechaHoraFinal) {
        this.fechaHoraFinal = fechaHoraFinal;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        if(precio >= 0) {
            this.precio = precio;
        }
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        if(calificacion >= 0 && calificacion <= 5) {
            this.calificacion = calificacion;
        }
    }

    @Override
    public String toString() {
        return "Viaje " + identificador + "\n\t" + "Cliente = " + cliente.toString() + "\n\t" + "Chofer = " + chofer.toString() + "\n\t$" + precio + "  " + calificacion + " estrellas";
    }
}
