/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Clase ENUM que define los niveles de descuento disponibles.
 */

// NOTA: Para cada enum en la lista de enums (BRONCE, PLATA, ORO), el compilador de Java
// creará una instancia de la clase Niveles y le asignará los valores definidos en los paréntesis.

public enum Niveles {
    // Enumeraciones con sus respectivos valores de descuento
    ANONIMO(0, 0),
    BRONCE(3, 3),
    PLATA(5, 6),
    ORO(10, 12);

    // Atributo que almacena el valor del descuento
    private int descuento;
    private int mesesSinIntereses;

    // Constructor privado para evitar la creación de más instancias
    Niveles(int descuento, int mesesSinIntereses) {
        this.descuento = descuento;
        this.mesesSinIntereses = mesesSinIntereses;
    }

    // Método para obtener el descuento
    public int getDescuento() {
        return descuento;
    }

    // Método para obtener los meses sin interes
    public int getMesesSinIntereses() {
        return mesesSinIntereses;
    }

    @Override
    public String toString() {
        String resultado = "\tNivel: " + name() + "\n\tDescuento: " + descuento + "%\n\tMSI: " + mesesSinIntereses; // name() regresa el valor del nombre del enum.
        return resultado;
    }
}
