/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Prueba de una clase genérica
 */

public class OtraGenerica <T, S>{
    public T atributo;

    public void despliega(S parametro) {
        System.out.println("Atributo: " + atributo);
        System.out.println("Parámetro: " + parametro);
    }
}
