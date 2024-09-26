/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Clase que representa a una persona con atributos básicos como nombre, edad, domicilio y género, e incluye métodos para gestionar estos atributos.
 */

public class Persona {

    // Atributos
    private String nombre; // Nombre de la persona
    private byte edad; // Edad de la persona
    private String domicilio; // Domicilio de la persona
    private char genero; // Género de la persona

    /**
     * Constructor por defecto que inicializa los atributos de la persona con valores predeterminados.
     */
    public Persona() {
        this.setNombre("Indefinido");
        this.setEdad((byte) 0);
        this.setDomicilio("Desconocido");
        this.setGenero('I');
    }

    /**
     * Método que verifica si la persona es adulta.
     * @return Un booleano que indica si es una persona adulta o no.
     */
    public boolean esAdulto() {
        return this.getEdad() > 17;
    }

    /**
     * Método para obtener el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la persona.
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la edad de la persona.
     * @return La edad de la persona.
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * Método para establecer la edad de la persona.
     * @param edad La edad a establecer.
     */
    public final void setEdad(byte edad) {
        if (this.edad > 16) {
            this.edad = edad;
        }
    }

    /**
     * Método para obtener el domicilio de la persona.
     * @return El domicilio de la persona.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Método para establecer el domicilio de la persona.
     * @param domicilio El domicilio a establecer.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Método para obtener el género de la persona.
     * @return El género de la persona.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Método para establecer el género de la persona.
     * @param genero El género a establecer.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Método sobrescrito para obtener una representación en cadena de la persona.
     * @return Una cadena que representa a la persona.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio='" + domicilio + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
