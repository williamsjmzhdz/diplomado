/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 04/05/2024
 *   Descripción: Imprime en consola la tabla de multiplicar (1 a 10) de un número entero positivo.
*/

import java.util.Scanner;

public class Tabla {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int numeroBase = teclado.nextInt();

        if(numeroBase <= 0) {
            System.out.println("Número inválido.");
            return;
        }

        int factor = 1;
        while (factor <= 10) {

            System.out.println(numeroBase + " x " + factor + " = " + (numeroBase * factor));

            factor++;

        }

    }
}
