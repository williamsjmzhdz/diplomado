/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 31/05/2025
 * Descripción: Clase de prueba Practica3 de la práctica 3
 */

public class Practica3 {

    public static void main(String[] args) {
        System.out.println("Prueba de clases de la práctica 3");
        // Cliente
        Cliente cliente1 = new Cliente();
        System.out.println("Cliente:" + cliente1);

        // Asociado (chofer)
        Asociado asociado1 = new Asociado();
        System.out.println("Asociado: " + asociado1);

        // Viaje
        Viaje viaje1 = new Viaje();
        viaje1.setCliente(cliente1);
        viaje1.setChofer(asociado1);
        viaje1.setPrecio(100.0);
        viaje1.setCalificacion(3.0);
        System.out.println("Viaje INICIAL: " + viaje1);

        viaje1.getChofer().setNombre("Phoebe Buffay");
        viaje1.getChofer().setGenero('F');

        viaje1.getCliente().setNombre("Chandler Bing");

        viaje1.setPrecio((double) -100);
        viaje1.setCalificacion(100.0);

        System.out.println("Viaje FINAL: " + viaje1);
    }
}
