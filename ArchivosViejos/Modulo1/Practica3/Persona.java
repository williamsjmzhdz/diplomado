
/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 31/05/2025
 * Descripción: Clase Persona de la práctica 3
 */

public class Persona {
    private String nombre; // Longitud de al menos 7 caracteres
    private byte edad;     // Será de 7 o más años
    private char genero;   // Femenino, Masculino, Desconocido, No quiso decirlo

    public Persona (){
        this.setNombre("Desconocido");
        this.setEdad((byte)10);
        this.setGenero('D');
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre.length() >=7 )
            this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }
    public void setEdad(byte edad) {
        if (edad >= 7)
            this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        String validos = "FMDN";  // Femenino, Masculino, Desconocido, No quiso decirlo
        if (validos.indexOf(genero) >= 0)
            this.genero = genero;
    }
}