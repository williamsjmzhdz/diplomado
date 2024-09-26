/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 24/05/2024
 * Descripción: Clase abstracta de ejemplo para practicar
 */

public abstract class ClaseAbstracta {

    // Una clase abstracta puede tener atributos definidos o incluso inicializados
    private String nombre;
    public int numero;

    // Una clase abstracta puede tener métodos concretos (definidos)
    public int suma(int otroNumero) {
        return this.numero += otroNumero;
    }

    // Método abstracto sin cuerpo
    public abstract int resta(int otroNumero);
    public abstract  int duplica();

    // NOTA: No es necesario que una clase abstracta tenga métodos abstractos
    // NOTA: Quien herede de una clase abstracta están obligados a definir los métodos
    // abstractos o volverse una clase abstracta, ya que si no define los métodos,
    // estos seguirían estando incompletos.

}
