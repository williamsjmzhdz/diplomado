/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Prueba de clases equivalentes
 */

public class ClasesEquivalentes {

    public static void imprime(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) {

        // Uso de clases equivalentes
        Casa o1 = new Casa();
        CuentaBancaria o2 = new CuentaBancaria("12345");
        Docente o3 = new Docente();

        int entero = 100;
        double doble = 99.8;

        imprime(o1);
        imprime(o2);
        imprime(o3);
        imprime(entero); // Hace la conversión implícita de int a Integer (su clase equivalente).
        imprime(doble); // Hace la conversión implícita de double a Double (su clase equivalente).

        /**
         * CLASES EQUIVALENTES
         * Byte, Short, Integer, Long, Character, Boolean
         * byte, short, int, long, char, boolean
         */

        Integer objetoEntero;
        Long objetoLong;

        objetoEntero = 356; // Asigna un int a un objeto tipo Integer gracias al autoboxing.
        objetoLong = -987L; // Asigna un long a un objeto tipo Long gracias al autoboxing.

        imprime(objetoEntero);
        imprime(objetoLong);

        System.out.println(objetoEntero + 100);

        // NOTA: Cuando el objeto de la clase equivalente se convierte al tipo primitivo, se le llama unboxing.
        // NOTA: Cuando el dato primitivo se convierte a un objeto de la clase equivalente, se le llama autoboxing.

        System.out.println(objetoEntero.doubleValue());
        entero = Integer.parseInt("12345"); // parseInt es método estático de la clase Integer.
        System.out.println(entero + 10);
        System.out.println(Integer.MAX_VALUE); // Atributo final estático de Integer.

    }

}
