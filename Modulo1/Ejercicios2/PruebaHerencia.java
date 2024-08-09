/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Ejemplo de herencia en Java, demostrando la creación y uso de instancias de clases que heredan de una clase base.
 */

public class PruebaHerencia {
    public static void main(String[] args) {
        // Imprimir título del ejemplo de herencia
        System.out.println("\t\tEjemplo de herencia en Java");

        // Creación de una instancia de la clase Persona
        Persona hugo = new Persona();
        System.out.println(hugo); // Imprimir detalles de la instancia de Persona

        // Creación de una instancia de la clase Estudiante
        Estudiante paco = new Estudiante();
        System.out.println(paco); // Imprimir detalles de la instancia de Estudiante
        paco.setEdad(true); // Cambia la edad a 18
        System.out.println(paco); // Imprimir detalles de la instancia de Estudiante

        // Creación de una instancia de la clase Egresado
        Egresado luis = new Egresado();
        System.out.println(luis); // Imprimir detalles de la instancia de Egresado

        // Creación de una instancia de la clase Docente
        Docente williams = new Docente();
        System.out.println(williams); // Imprimir detalles de la instancia de Docente
        williams.setNombre("Jorge");
        williams.setEdad((byte) 40);

        // ¿De quién/quiénes es una instancia el objeto williams?
        System.out.println("¿El objeto williams es instancia de Docente? " + ((williams instanceof Docente) ? "Si" : "No"));
        System.out.println("¿El objeto williams es instancia de Persona? " + ((williams instanceof Persona) ? "Si" : "No"));
        System.out.println("El objeto williams es de tipo: " + williams.getClass());

        Docente jorge = new Docente();
        jorge.setNombre("Jorge");
        jorge.setEdad((byte) 40);
        jorge.equals(williams);
    }
}
