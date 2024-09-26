/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 03/05/2024
 *   Descripción: Definición y uso de variables
*/

public class Variables {

    public static void main(String[] args) {
        // Variables booleanas para control de estados lógicos
        boolean aprobado = true;
        boolean soltero = false;
        System.out.println("Aprobado: " + aprobado);

        // Variables numéricas enteras con anotaciones sobre sus rangos
        byte edad = 99; // Rango de byte: -128 a 127
        short peso = 136; // Rango de short: -32,768 a 32,767
        int salario = 98765; // Rango de int: -2,147,483,648 a 2,147,483,647
        long enteroGrande = 837_464_582L; // Rango de long: -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
        System.out.println("Edad: " + edad + " años");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Salario: $" + salario);
        System.out.println("Valor largo: " + enteroGrande);

        // Variables numéricas de tipo real
        float edadReal = 98.7F; // La 'F' es necesaria para indicar que el literal es de tipo float
        double pesoReal = 123.45; // El tipo double es el predeterminado para números con punto decimal
        System.out.println("Edad real: " + edadReal + " años");
        System.out.println("Peso real: " + pesoReal + " kg");

        // Uso de char para almacenar caracteres individuales
        char inicial = 'E';
        System.out.println("Inicial: " + inicial);

        // Uso de String para cadenas de texto
        String nombre = "UNAM";
        System.out.println("Nombre: " + nombre);

        // Operaciones aritméticas y asignaciones en una línea
        double numero = 789; // Inicialización y asignación
        System.out.println("Numero: " + numero);
        numero = edad = 78; // Asignación encadenada, ambos numero y edad se convierten a 78
        System.out.println("Numero y Edad ajustados a: " + numero);

        // Ámbito de las variables
        int calificacion = 10;
        System.out.println("Calificación: " + calificacion);

        { // Bloque interno con su propio ámbito
            int asistencias = 9;
            System.out.println("Asistencias en bloque interno: " + asistencias);
        }
        // System.out.println(asistencias); // 'asistencias' no está disponible fuera del bloque interno

        // Promoción de tipos en expresiones
        double real = 2 * (3 / 2); // Resultado es 2.0 debido a que la división entera precede a la multiplicación
        System.out.println("Resultado sin promoción: " + real);
        real = 2 * (3.0 / 2); // Ahora realiza una división en punto flotante primero, resultando en 3.0
        System.out.println("Resultado con promoción: " + real);

        // Casting o conversión explícita: convertir explícitamente un valor de un tipo a otro.

        // Convertir 1.5 (double) a int. Dado que 1.5 es un double, al castearlo a int, se descarta la parte decimal.
        numero = (int) 1.5; // numero = 1
        System.out.println("Casting de 1.5 a int: " + numero);

        // Convertir el resultado de 1.5 * 2.4 (ambos doubles) a int. El resultado de la multiplicación es 3.6, que al castear a int se convierte en 3.
        numero = (int) (1.5 * 2.4); // numero = 3
        System.out.println("Casting de 1.5 * 2.4 a int: " + numero);

        // En esta línea, primero se convierte 1.34 a int, que es 1, y luego se multiplica por 10. Es importante entender el orden de las operaciones.
        numero = (int) 1.34 * 10; // numero = 10, porque primero se hace la conversión (1) y luego la multiplicación (1 * 10).
        System.out.println("Casting de 1.34 a int antes de multiplicar por 10: " + numero);


    }
}
