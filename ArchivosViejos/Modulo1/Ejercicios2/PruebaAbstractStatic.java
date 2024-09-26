
/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 24/05/2024
 * Descripción: Clase para probar la clase abstracta
 */

public class PruebaAbstractStatic {
    public static void main(String[] args) {
        System.out.println("Ejemplo de abstract y de static");

        // abstract
        // Una clase abstracta no se puede instanciar.
        // ClaseAbstracta objeto = new ClaseAbstracta();

        // static
        ClaseConEstaticos objeto3 = new ClaseConEstaticos();
        objeto3.numero = 55;

        ClaseConEstaticos objeto4 = new ClaseConEstaticos();
        objeto4.numero =44;

        System.out.println(objeto3.numero);
        System.out.println(objeto4.numero);

        // Uso de elementos estáticos
        System.out.println(objeto3.real); // Se puede usar estáticos a través de instancias
        System.out.println(ClaseConEstaticos.real); // Pero lo correcto es usarlo a través de la clase

        // Métodos no estáticos; cada objeto utiliza su copia del método con su copia de atributos
        objeto3.metodoNoEstatico();
        objeto4.metodoNoEstatico();

        // Métodos estáticos: se pueden usar a través de una instancia pero no es lo recomendable: Mala práctica
        objeto3.metodoEstatico(); // A través de una instancia: marca warning de mala práctica
        ClaseConEstaticos.metodoEstatico(); // A través de la clase

    }
}
