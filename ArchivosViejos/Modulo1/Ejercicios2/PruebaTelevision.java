/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Ejemplo de uso de la clase Television, demostrando operaciones como encender/apagar, ajustar volumen y cambiar canales.
 */

public class PruebaTelevision {
    public static void main(String[] args) {
        // Crear una instancia de la clase Television
        Television tv1 = new Television();

        // Encender la televisión
        tv1.encenderApagar();
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Subir el volumen 10 niveles
        subirVolumen(tv1, 10);
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Silenciar la televisión
        tv1.silenciar();
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Quitar el silencio de la televisión
        tv1.silenciar();
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Apagar la televisión
        tv1.encenderApagar();
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Encender la televisión
        tv1.encenderApagar();
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Cambiar el canal hacia arriba 4 veces
        canalMas(tv1, 4);
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Cambiar el canal hacia abajo 5 veces
        canalMenos(tv1, 5);
        System.out.println(tv1.toString()); // Imprimir estado de la televisión

        // Uso de los métodos default de la interfaz IcontrolesUniversales
        tv1.imprimeStatus();
    }

    /**
     * Sube el volumen de la televisión n veces.
     * @param tv La televisión a la que se le subirá el volumen.
     * @param n El número de veces que se subirá el volumen.
     */
    public static void subirVolumen(Television tv, int n) {
        while(n > 0) {
            tv.subirVolumen();
            n--;
        }
    }

    /**
     * Cambia el canal hacia arriba n veces.
     * @param tv La televisión a la que se le cambiará el canal.
     * @param n El número de veces que se cambiará el canal hacia arriba.
     */
    public static void canalMas(Television tv, int n) {
        while(n > 0) {
            tv.canalMas();
            n--;
        }
    }

    /**
     * Cambia el canal hacia abajo n veces.
     * @param tv La televisión a la que se le cambiará el canal.
     * @param n El número de veces que se cambiará el canal hacia abajo.
     */
    public static void canalMenos(Television tv, int n) {
        while(n > 0) {
            tv.canalMenos();
            n--;
        }
    }
}
