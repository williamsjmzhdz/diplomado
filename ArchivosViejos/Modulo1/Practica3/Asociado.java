/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 31/05/2025
 * Descripción: Clase Asociado de la práctica 3
 */

public class Asociado extends Persona {
    private int id;
    private int antiguedad;
    private Double calificacionPromedio;

    public Asociado(){
        super();
        setId(1);
        setAntiguedad(0);
        setCalificacionPromedio(0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        }
    }

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        if(calificacionPromedio >= 0 && calificacionPromedio <= 5) {
            this.calificacionPromedio = calificacionPromedio;
        }
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        if(antiguedad >= 0)  {
            this.antiguedad = antiguedad;
        }
    }

    @Override
    public void setEdad(byte edad) {
        if(edad > 18 && edad < 60) {
            super.setEdad(edad);
        }
    }

    @Override
    public String toString() {
        return "Asociado " + id + ": " + super.getNombre() + " (" + super.getGenero() + ") " + calificacionPromedio + " estrellas promedio";
    }
}
