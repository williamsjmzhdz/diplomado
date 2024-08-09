/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Clase que representa a un egresado, extendiendo de la clase Estudiante. Incluye un atributo específico de generación y métodos para su manejo.
 */

public final class Egresado extends Estudiante {

    // Atributo que representa la generación del egresado
    private short generacion;

    /**
     * Constructor por defecto que inicializa la generación a 2000.
     */
    public Egresado() {
        this.setGeneracion((short) 2000);
    }

    /**
     * Método para obtener la generación del egresado.
     * @return La generación del egresado.
     */
    public short getGeneracion() {
        return generacion;
    }

    /**
     * Método para establecer la generación del egresado.
     * @param generacion La generación a establecer.
     */
    public void setGeneracion(short generacion) {
        this.generacion = generacion;
    }

    // No se puede sobreescribir setEdad(byte edad) porque se definió como final en la superclase
    // por lo tanto no se pude sobreescribir en ninguna de sus subclases.
    /**
     * public void setEdad(byte edad) {}
    */

    /**
     * Método sobrescrito para obtener una representación en cadena del egresado.
     * @return Una cadena que representa al egresado.
     */
    @Override
    public String toString() {
        return "Egresado{" +
                "generacion=" + generacion +
                "} " + super.toString();
    }
}
