/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 11/05/2024
 * Descripción: Ejemplo de definición, inicialización y uso de arreglos bidimensionales en Java para almacenar calificaciones de varios estudiantes.
 */
public class Arreglos2D {

    public static void main(String[] args) {
        // Inicialización del arreglo con los nombres de los primos
        String[] primos = {"Hugo", "Paco", "Luis"};

        // Definición de un arreglo bidimensional para calificaciones.
        // 3 estudiantes (Hugo, Paco, Luis) y cada uno con 4 tipos de calificaciones:
        // ejercicios, prácticas en clase, proyecto final y participación en clase.
        double[][] calificaciones = new double[3][4];

        // Asignación de una calificación de 10 a Paco (índice 1) en el proyecto final (índice 2)
        calificaciones[1][2] = 10;

        // Bucle anidado para imprimir todas las calificaciones de cada estudiante
        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[i].length; j++) {
                System.out.println("Estudiante: " + primos[i] + ", Categoría de calificación: " + j + ", Calificación: " + calificaciones[i][j]);
            }
        }
    }
}
