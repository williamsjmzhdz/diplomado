/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 04/05/2024
 *   Descripción: Definición y uso de ciclos while y do-while
*/

public class EjemploWhile {

    public static void main(String[] args) {

        // Variable de control
        int contador = 0;

        /* Estructura cíclica while */

        // Mientras el contador sea menor que 5
        while(contador < 5) { // Ejecuta este bloque de código

            System.out.println("El contador tiene el valor: " + contador);

            // Actualiza el valor de la variable de control en cada iteración
            // para evitar ciclos infinitos
            contador++;

        }

        System.out.println("\nEjercicio: imprime los valores del contador del 1 al 10");

        // Reasignación de la variable de control
        contador = 1;

        // Imprime en consola los valores del contador del 1 al 10
        while(contador <= 10) {

            System.out.println("El contador tiene el valor de " + contador);

            contador++;

        }

        /* Estructura cíclica do-while */

        System.out.println("\nEstructura cíclica do-while");

        contador = 100;

        do { // Primero ejecuta el bloque de código, por lo tanto, lo ejecuta al menos una vez
            System.out.println(contador++);
        } while (contador <= 10); // Después evalúa la expresión booleana

    }

}
