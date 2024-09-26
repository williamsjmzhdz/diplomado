/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Clase que representa a un estudiante, extendiendo de la clase Persona. Incluye atributos específicos del estudiante como matrícula, promedio y carrera, así como métodos para su gestión.
 */

public class Estudiante extends Persona {

    // Atributos
    private int matricula; // Matrícula del estudiante
    private byte promedio; // Promedio del estudiante
    private String carrera; // Carrera del estudiante
    private byte edad;

    /**
     * Constructor por defecto que llama al constructor de la clase padre (Persona).
     */
    public Estudiante() {
        super();
    }

    /**
     * Constructor que inicializa la matrícula del estudiante.
     * @param matricula Matrícula del estudiante.
     */
    public Estudiante(int matricula) {
        this();
        this.setMatricula(matricula);
    }

    /**
     * Método para cambiar la edad de la persona.
     * @param esMayorDeEdad booleano para saber si es mayor de edad.
     */
    public void setEdad(boolean esMayorDeEdad) {
        this.setEdad((byte) (esMayorDeEdad ? 18 : 10));
    }

    /**
     * Método para obtener la matrícula del estudiante.
     * @return La matrícula del estudiante.
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Método para establecer la matrícula del estudiante.
     * @param matricula La matrícula a establecer.
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Método para obtener el promedio del estudiante.
     * @return El promedio del estudiante.
     */
    public byte getPromedio() {
        return promedio;
    }

    /**
     * Método para establecer el promedio del estudiante.
     * @param promedio El promedio a establecer.
     */
    public void setPromedio(byte promedio) {
        this.promedio = promedio;
    }

    /**
     * Método para obtener la carrera del estudiante.
     * @return La carrera del estudiante.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Método para establecer la carrera del estudiante.
     * @param carrera La carrera a establecer.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Método sobrescrito para obtener una representación en cadena del estudiante.
     * @return Una cadena que representa al estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                ", promedio=" + promedio +
                ", carrera='" + carrera + '\'' +
                "} " + super.toString();
    }
}
