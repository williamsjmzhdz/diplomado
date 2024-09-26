package mx.unam.dgtic.datos;

import java.util.Date;

public class Evaluacion {

    private String materia;
    private double calificacion;
    private Date fecha;

    public Evaluacion() {
    }

    public Evaluacion(String materia, double calificacion, Date fecha) {
        this.materia = materia;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "materia='" + materia + '\'' +
                ", calificacion=" + calificacion +
                ", fecha=" + fecha +
                '}';
    }
}
