/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 04/05/2024
 *   Descripción: Definición y uso de switch
*/

import java.util.Scanner;

public class EjemploSwitch {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántas faltas tuviste en el curso? ");
        int faltas = teclado.nextInt();

        /* Estructura de control switch */

        // Establece una variable de control (nota: funciona con distintos tipos de dato)
        switch(faltas) {
            case 0: // Si la variable de control es 0
                System.out.println("Felicidades, asististe a todas las clases.");
                // Rompe la estructura de control y sale de ella.
                // Si no se pone, se ejecutan los siguientes casos hasta encontrarse con un break.
                break;
            case 1: // Si la variable de control es 1
                System.out.println("Solo tuviste 1 falta.");
                break;
            case 2: // Si la variable de control es 2
                System.out.println("Tuviste 2 faltas.");
                break;
            default: // Este caso se ejecuta si ninguno de los anteriores se cumple.
                System.out.println("Tuviste demasiadas faltas.");
                break;
        }

        /* Estructura switch como expresión - Disponible a partir de Java 14 */

        // Variable de control
        char turnoAbreviado = 'V';

        // La estructura switch retorna un valor dependiendo el valor de la variable de control.
        String turno = switch(turnoAbreviado) {
            case 'M' -> "Matutino";
            case 'V' -> "Vespertino";
            default -> "Mixto";
        };
        System.out.println("La abreviación '" + turnoAbreviado + "' corresponde al turno " + turno);

    }

}
