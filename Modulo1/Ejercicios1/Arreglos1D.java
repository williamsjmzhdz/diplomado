/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 11/05/2024
 * Descripción: Ejemplo de definición, inicialización y uso de arreglos unidimensionales en Java.
 */
public class Arreglos1D {

    public static void main(String[] args) {
        // Inicialización del arreglo de nombres de primos
        String[] primos = new String[3];
        primos[0] = "Hugo";
        primos[1] = "Paco";
        primos[2] = "Luis";

        // Inicialización del arreglo de calificaciones con valores predefinidos
        double[] calificaciones = {9.8, 6.9, 7.45};

        // Bucle para imprimir los elementos de los arreglos con su índice correspondiente
        for (int i = 0; i < primos.length; i++) {
            System.out.println("Primo: " + primos[i] + " con índice " + i + " tiene una calificación de " + calificaciones[i]);
        }
    }
}
