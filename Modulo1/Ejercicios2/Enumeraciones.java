/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Clase para ejemplificar la definición y uso de enumeraciones.
 */

// Formato de una enumeración: enum [NOMBRE_ENUMERACION] {valor1, valor2, ..., valorN};
enum Logico {VERDADERO, FALSO};
enum Turno {MATUTINO, VESPERTINO, MIXTO};

public class Enumeraciones {

    public static void main(String[] args) {

        // Uso de la enumeración Logico
        Logico registrado = Logico.VERDADERO;
        Logico aprobo = Logico.FALSO;
        System.out.println("¿Está registrado? " + registrado);
        System.out.println("¿Está aprobado? " + aprobo);

        // Uso de la enumeración Turno
        Turno raul = Turno.VESPERTINO;
        Turno lucia = Turno.MATUTINO;
        Turno williams = Turno.MIXTO;
        System.out.println("Turno de Raúl: " + raul);
        System.out.println("Turno de Lucía: " + lucia);
        System.out.println("Turno de Williams: " + williams);
        System.out.println("¿Raúl y Lucia están en el mismo turno?: " + (raul == lucia));

        // Uso de enumeraciones definidas en su propio archivo .java
        Niveles nivelRaul = Niveles.BRONCE;
        System.out.println("RAÚL \n" + nivelRaul + "\n");

        Niveles nivelLucia = Niveles.ANONIMO;
        System.out.println("LUCIA \n" + nivelLucia + "\n");
    }

}
