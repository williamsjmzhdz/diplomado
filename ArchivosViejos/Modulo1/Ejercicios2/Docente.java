import java.util.Objects;

/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Clase que representa a un docente, extendiendo de la clase Persona. Incluye atributos específicos del docente como el número de empleado, antigüedad, nivel y RFC.
 */

public class Docente extends Persona {

    // Atributos
    private short numeroEmpleado; // Número de empleado del docente
    private byte antiguedad; // Antigüedad del docente en años
    private char nivel; // Nivel del docente (por ejemplo, A, B, C)
    private String rfc; // Registro Federal de Contribuyentes del docente

    // Métodos, constructores, getters y setters se pueden agregar aquí según sea necesario

    public short getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(short numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public byte getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(byte antiguedad) {
        this.antiguedad = antiguedad;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return getNumeroEmpleado() == docente.getNumeroEmpleado() && getNivel() == docente.getNivel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroEmpleado(), getNivel());
    }
}
