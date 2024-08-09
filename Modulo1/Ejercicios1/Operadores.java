/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 03/05/2024
 *   Descripción: Uso de operadores
*/

public class Operadores {
    public static void main(String[] args) {
        // Ejemplos de operadores aritméticos
        System.out.println("Suma: " + (10 + 3)); // Suma dos números enteros
        System.out.println("Resta: " + (10 - 3)); // Resta dos números enteros
        System.out.println("Multiplicación: " + (10 * 3)); // Multiplica dos números enteros
        System.out.println("División: " + (10.0 / 3)); // Divide dos números, resultando en un valor decimal
        System.out.println("Módulo: " + (10 % 3)); // Calcula el residuo de la división de 10 entre 3

        // Inicialización de la variable
        int numero = 10;

        // Demostración de operadores de asignación compuesta
        numero += 5; // Incrementa el valor de 'numero' en 5
        System.out.println("Incrementado a: " + numero);
        numero -= 3; // Decrementa el valor de 'numero' en 3
        System.out.println("Decrementado a: " + numero);
        numero *= 2; // Multiplica el valor de 'numero' por 2
        System.out.println("Multiplicado a: " + numero);
        numero /= 2; // Divide el valor de 'numero' por 2
        System.out.println("Dividido a: " + numero);
        numero %= 4; // Calcula el módulo de 'numero' con respecto a 4
        System.out.println("Módulo de 4: " + numero);

        // Uso de operadores unarios de incremento y decremento
        numero++; // Incrementa 'numero' en 1
        System.out.println("Incremento postfijo: " + numero);
        numero--; // Decrementa 'numero' en 1
        System.out.println("Decremento postfijo: " + numero);

        // Ejemplos de incremento postfijo y prefijo
        numero = 0;
        System.out.println("Valor antes del incremento postfijo: " + numero++); // Muestra el valor de 'numero' antes de incrementarlo
        numero = 0;
        System.out.println("Valor después del incremento prefijo: " + ++numero); // Incrementa 'numero' y luego lo muestra

        // Operadores de comparación
        System.out.println("Es mayor que 99: " + (numero > 99)); // Compara si 'numero' es mayor que 99
        System.out.println("Es menor que 99: " + (numero < 99)); // Compara si 'numero' es menor que 99
        System.out.println("Es igual o mayor que 99: " + (numero >= 99)); // Compara si 'numero' es mayor o igual a 99
        System.out.println("Es igual o menor que 99: " + (numero <= 99)); // Compara si 'numero' es menor o igual a 99
        System.out.println("Es igual a 99: " + (numero == 99)); // Compara si 'numero' es igual a 99
        System.out.println("Es diferente de 99: " + (numero != 99)); // Compara si 'numero' es diferente de 99

        // Operadores lógicos
        boolean tieneDiscapacidad = false;
        int edad = 20;
        // Ejemplo de uso de operadores lógicos 'or' (||) y 'and' (&&)
        System.out.println("¿Tiene atención preferencial?: " + (tieneDiscapacidad || edad >= 65)); // Comprueba si tiene discapacidad o si es mayor o igual a 65 años

        // Nota sobre el cortocircuito
        // Los operadores '||' y '&&' son de cortocircuito, lo que significa que si la primera condición es suficiente
        // para determinar el resultado, la segunda condición no se evalúa.
        // En cambio, los operadores '|' y '&' siempre evalúan ambas condiciones.

        // Operador ternario (if in-line)
        System.out.println(edad >= 18 ? "Ya puedes votar." : "Aún no puedes votar."); // Verifica si es mayor o igual a 18 años

        // Operaciones bit a bit
        // Para una hamburguesa podemos utilizar diferentes ingredientes y representarlos con bits
        // cebolla-catsup-mostaza
        //    0      0       0       0
        //    1      0       0       4
        //    1      1       1       7
        //    1      0       1       5

        byte hamburguesa = 5;
        System.out.println("¿Tiene cebolla?: " + ((hamburguesa & 4) > 0)); // Verifica si la cebolla está presente (bit 2)
        System.out.println("¿Tiene catsup?: " + ((hamburguesa & 2) > 0)); // Verifica si el catsup está presente (bit 1)
        System.out.println("¿Tiene mostaza?: " + ((hamburguesa & 1) > 0)); // Verifica si la mostaza está presente (bit 0)

        System.out.println("¿Agregar catsup?: " + (hamburguesa | 2)); // Agrega catsup (encendiendo el bit 1)

        // Operadores XOR, ~, >>, << y >>>
        // Explica y pon ejemplos de estos operadores
        // Operador XOR: ^
        int a = 5; // Representado en binario como 101
        int b = 3; // Representado en binario como 011
        int resultadoXOR = a ^ b; // Resultado es 110, que es 6 en decimal
        System.out.println("XOR de 5 y 3 es: " + resultadoXOR);

        // Operador de inversión: ~
        int c = 5; // Representado en binario como 101
        int resultadoInversion = ~c; // Resultado es -6
        System.out.println("Inversión de 5 es: " + resultadoInversion);

        // Operadores de desplazamiento: >> y <<
        int d = 8; // Representado en binario como 1000
        int resultadoDesplazamientoDerecha = d >> 2; // Resultado es 0010, que es 2 en decimal
        System.out.println("Desplazamiento de 8 a la derecha por 2 posiciones es: " + resultadoDesplazamientoDerecha);

        int e = 4; // Representado en binario como 0100
        int resultadoDesplazamientoIzquierda = e << 1; // Resultado es 1000, que es 8 en decimal
        System.out.println("Desplazamiento de 4 a la izquierda por 1 posición es: " + resultadoDesplazamientoIzquierda);

        // Operador de desplazamiento lógico sin signo: >>>
        int f = -8; // Representado en binario como 11111111111111111111111111111000 (en complemento a dos)
        int resultadoDesplazamientoLogico = f >>> 1; // Desplaza los bits hacia la derecha y llena con ceros
        System.out.println("Desplazamiento lógico de -8 hacia la derecha por 1 posición es: " + resultadoDesplazamientoLogico);
    }
}
