/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 25/05/2024
 * Descripción: Clase para probar la clase genérica
 */

public class PruebaGenericos {

    public static void main(String[] args) {

        Generica<String> o1 = new Generica<>();
        o1.atributo = "¡Hola Mundo!";
        o1.numero = 34;
        o1.imprime("Hola", "Mundo");


        Generica<CuentaBancaria> o2 = new Generica<>();
        o2.atributo = new CuentaBancaria("12345");
        o2.numero = 86;
        o2.imprime("Adiós", new CuentaBancaria("98765"));

        Generica<Docente> o3 = new Generica<>();
        o3.atributo = new Docente();
        o3.numero = -14;
        o3.imprime("UNAM", new Docente());

        Generica<Estudiante> o4 = new Generica<>();
        o4.atributo = new Estudiante();
        o4.numero = -14;
        o4.imprime("UNAM", new Estudiante());

        // Generica con dos clases como parámetro
        System.out.println("Uso de genérica con dos parámetros.");
        OtraGenerica<String, Double> o5 = new OtraGenerica<>();
        o5.atributo = "Hola";
        o5.despliega(67.9);

        OtraGenerica<Casa, Persona> o6 = new OtraGenerica<>();
        o6.atributo = new Casa();
        o6.despliega(new Persona());

    }

}
