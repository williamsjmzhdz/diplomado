/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Interface para un control de un dispositivo electrónico (tv, radio).
 */

public interface IcontrolesUniversales {

    // Definición de atributos: tienen que ser estáticos
    public static final int VOLUMEN_MAXIMO = 100;
    public static final int VOLUMEN_MINIMO = 0;

    // NOTAS SOBRE ATRIBUTOS
    // public int ejemploInt1; Una interfaz NO PUEDE tener atributos no inicializados.
    // public int ejemploInt = 1; // Una interfaz puede tener atributos no estáticos y no constantes.
    // public static double ejemplo = 143.4; // Una interfaz puede tener atributos no constantes.

    // Definición de métodos abstractos
    public abstract void subirVolumen();
    public abstract void bajarVolumen();
    public abstract boolean encenderApagar();

    // NOTA: A partir de la versión 9 de Java, se puede definir métodos en interfaces (métodos default).
    // Métodos default
    default void imprimeStatus() {
        System.out.println("Muestro el estatus.");
    }

}
