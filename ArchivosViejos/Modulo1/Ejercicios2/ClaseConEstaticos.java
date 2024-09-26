
/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 24/05/2024
 * Descripción: Clase con miembros estáticos
 */

public class ClaseConEstaticos {

    public String texto;
    public int numero;
    public static double real = 98.7; // Atributo estático

    // NOTA: Los elementos estáticos se pueden utilizar sin instanciar la clase, y siempre se
    // usan a través del nombre de la clase ya que pertenecen a la clase en sí y no a las instancias.
    // NOTA: Solo se crea una copia en memoria de un elemento estático, no n copias.

    public void metodoNoEstatico() {
        System.out.println("Método no estático. El número = " + this.numero);
    }

    public static void metodoEstatico() {
        // Como un método estático se puede usar SIN INSTANCIAS, no dejará acceder a atributos de instancias
        // System.out.println("Método no estático. El número = " + this.numero);

        System.out.println("Método estático. El atributo estático es: " + real);
    }

}
