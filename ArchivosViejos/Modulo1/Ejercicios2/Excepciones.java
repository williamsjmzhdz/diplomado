import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 24/05/2024
 * Descripción: Clase para probar el manejo de excepciones
 */

public class Excepciones {

    public static void main(String[] args) {

        String[] meses = {
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre",
        };

        System.out.println("Manejo de excepciones");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Dame un número... ");

        // Si sucede una excepción en el código dentro del bloque try
        try {
            //teclado.close();
            int numero = teclado.nextInt();
            System.out.println("100 entre dicho número es " + (100 / numero));
            System.out.println("Mi mes favorito es: " + meses[4]);

        } // Catch atrapa la excepción de tipo InputMismatchException y la maneja.
        catch (InputMismatchException e) {
            System.out.println("Valor de entrada inválido; debe ser de tipo entero.");

        } // Catch atrapa una excepción de tipo ArithmeticException y la maneja.
        catch (ArithmeticException e) {
            System.out.println("Advertencia: no se puede dividir entre 0.");

        } // Catch atrapa una excepción de tipo ArrayIndexOutOfBoundsException y la maneja.
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice inválido; el índice está fuera del rango del arreglo.");
        }
        // Catch atrapa cualquier tipo de excepción que no sea de los tipos anteriores.
        catch (Exception e) {
            System.out.println("Ocurrió una excepción inesperada: " + e);
        }

        // NOTA: los bloques try-catch sirven para manejar posibles excepciones durante la
        // ejecución del código permitiéndonos manejarlas de una forma adecuada evitando el
        // cierre abrupto del programa.

    }

}
