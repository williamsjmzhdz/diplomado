/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Clase para probar genéricos
 */

// Clase genérica, con un parámetro genérico T (puede ser cualquier tipo de dato u objeto)
// NOTA: puedo controlar que el genérico solo tome objetos de una clase o sus subclases con
// <[NOMRE_GENERICO] extends [NOMBRE_CLASE]>
public class Generica <T> {

    public T atributo;
    public int numero;

    public void imprime(String p1, T p2) {
        System.out.println("(" + numero + ") = " + atributo);
        System.out.println(p1 + "--" + p2);
    }

}
