/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 04/05/2024
 *   Descripción: Definición y uso de subrutinas (procedimientos y funciones) y sobrecarga
*/

public class Subrutinas {

    /* Define subrutinas de tipo procedimiento (no retornan valor) */

    public static void saludaNVeces(int nVeces) {

        saludaNVeces(nVeces, "Anónimo");

    }

    // Procedimiento que sobrecarga al procedimiento saludaNVeces() anterior:
    // mismo nombre, diferente firma de parámetros
    public static void saludaNVeces(int nVeces, String nombre) {

        for(int i = 0; i < nVeces; i++) {

            System.out.println("Hola " + nombre);

        }

    }

    /* Define subrutinas de tipo función (retornan valor) */

    public static double suma (int operando1, int operando2) {

        // Retorna el resultado de sumar ambos operandos convertido a double
        return (double) (operando1 + operando2);

    }

    // Funciones que sobrecargan a la función suma() anterior:
    // mismo nombre, diferente firma de parámetros

    public static double suma (double operando1, double operando2) {

        return operando1 + operando2;

    }

    public static String suma (char operando1, char operando2) {

        return "" + operando1 + operando2;

    }

    public static void main(String[] args) {

        /* Llamadas a procedimientos */

        System.out.println("\nEjecuciones del procedimiento saludaNVeces(int)");
        saludaNVeces(5);

        System.out.println("\nEjecuciones del procedimiento saludaNVeces(int, String)");
        saludaNVeces(5, "Williams");


        /* Llamadas a funciones */

        System.out.println("\nEjecuciones de la función suma(int, int): double");
        System.out.println(8 + " + " + 2 + " = " + suma(8, 2));
        System.out.println("8 (char)" + " + " + "2 (char)" + " = " + suma('8', '2'));

        System.out.println("\nEjecuciones de la función suma(double, double): double");
        System.out.println(8.0 + " + " + "2 (char)" + " = " + suma(8.0, '2'));

        System.out.println("\nEjecuciones de la función suma(char, char): String");
        System.out.println("E" + " + " + "O" + " = " + suma('E', 'O'));

    }

}
