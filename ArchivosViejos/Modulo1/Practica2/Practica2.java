import java.util.Scanner;

public class Practica2 {
    public static void main(String[] args) {

        // Scanner para leer datos del teclado
        Scanner teclado = new Scanner(System.in);

        // Carrito de compras para almacenar los productos comprados
        Producto[] carrito = new Producto[100];

        // Índice para el carrito
        int numProducto = 0;

        // Contador del subtotal
        double subTotal = 0;

        // Contador de la cantidad de productos en el carrito
        int cantidadProductos = 0;

        while(true) {
            System.out.print("Producto (<Enter> para salir): ");

            // Lee el código
            String input = teclado.nextLine();

            // Si solo presionó enter, termina el ciclo
            if (input.equals("")) {
                System.out.println("Fin de la venta\n");
                break;
            }

            // Crea el producto
            Producto producto = new Producto(Integer.parseInt(input));

            // Verifica que sea un producto existente
            if (producto.getCodigo() == -1) {
                System.out.println("\tProducto INEXISTENTE\n");
                continue;
            }

            // Si es producto válido, lo agrega al carrito
            carrito[numProducto] = producto;

            // Va haciendo la suma del subTotal de productos para evitar hacerlo después
            // y actualiza la cantidad de productos en el carrito
            subTotal += producto.getPrecio();
            cantidadProductos++;

            // Imprime el producto y el total de productos
            System.out.println("\t" + producto.toString());
            System.out.println("\t+ Lleva " + cantidadProductos + " productos ($ " + subTotal + " antes del IVA)\n");

        }


        // Imprime el resumen final de la venta
        System.out.println("RESUMEN FINAL: " + cantidadProductos + " productos");
        System.out.println("Subtotal: $ " + subTotal);
        System.out.println("IVA:      $ " + subTotal * 0.16);
        System.out.println("Total:    $ " + (subTotal + (subTotal * 0.16)));


    }
}
