/*
 *   Autor: Francisco Williams Jiménez Hernández
 *   Fecha: 11/05/2024
 *   Descripción: Práctica 1: Programa de simulacro de elecciones 2024.
 */

import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {

        // Buffer de lectura de datos
        Scanner teclado = new Scanner(System.in);

        // Bandera para controlar el bucle while
        boolean continuar = true;

        // Variables para almacenar el número de votos por candidato Y total
        int votosClaudia = 0;
        int votosXochitl = 0;
        int votosMaynez = 0;
        int votosNulos = 0;
        int votosTotales = 0;

        // Solicita la cantidad de posibles votantes
        System.out.print("¿Cuántos posibles votantes hay?: ");
        int cantidadPosiblesVotantes = teclado.nextInt();

        // Mientras siga habiendo votaciones
        while(continuar == true && votosTotales < cantidadPosiblesVotantes) {

            // Muestra el menú
            System.out.println("\n\n\t\tSIMULACRO DE ELECCIONES 2024\t\t");
            System.out.print(
                    "1. Claudia Sheinbaum Pardo (MORENA)\n" +
                            "2. Bertha Xóchitl Gálvez Ruiz (PRI/PAN/PRD)\n" +
                            "3. José Álvarez Maynez (Movimiento Ciudadano)\n" +
                            "3. José Álvarez Maynez (Movimiento Ciudadano)\n" +
                            "4. Ninguno (Voto Nulo)\n" +
                            "9. Terminar\n" +
                            "¿Por quién vas a votar? (9 para terminar): "
            );

            // Lee la elección
            int eleccion = teclado.nextInt();

            // Actualiza o termina las votaciones
            switch(eleccion) {

                case 1:
                    votosClaudia++;
                    votosTotales++;
                    break;
                case 2:
                    votosXochitl++;
                    votosTotales++;
                    break;
                case 3:
                    votosMaynez++;
                    votosTotales++;
                    break;
                case 4:
                    votosNulos++;
                    votosTotales++;
                    break;
                case 9:
                    teclado.close();
                    continuar = false;
                    break;
                default:
                    System.out.println("ADVERTENCIA: '" + eleccion + "' No es una opción válida, intente de nuevo.");

            }

        }

        // Imprime los resultados en pantalla
        System.out.println("\n\n\t\tRESULTADOS FINALES\t\t");
        imprimeResultados("Claudia Sheinbaum Pardo (MORENA)", votosClaudia, votosTotales);
        imprimeResultados("Bertha Xóchitl Gálvez Ruiz (PRI/PAN/PRD)", votosXochitl, votosTotales);
        imprimeResultados("José Álvarez Maynez (Movimiento Ciudadano)", votosMaynez, votosTotales);
        imprimeResultados("Ninguno (Voto Nulo)", votosNulos, votosTotales);

        // Imprime la participación de los votantes
        System.out.println("\nVotos esperados: " + cantidadPosiblesVotantes);
        System.out.println("Votos totales: " + votosTotales);
        System.out.println("Porcentaje de participación: " + (((double) votosTotales) / cantidadPosiblesVotantes) * 100 + "%");


    }

    // Imprime las gráficas de estrellas con base en los votos por candidato
    public static void imprimeResultados(String nombreCandidato, int votosCandidato, int votosTotales) {

        // Imprime el número y porcentaje de votos para el candidato
        System.out.println(nombreCandidato + ": " + votosCandidato + " votos = " + (((double) votosCandidato) / votosTotales) * 100 + "%");

        // Tamaño máximo de la gráfica (50 asteriscos)
        int tamanioMaxGrafica = 50;

        // Calcula el tamaño de la gráfica para el candidato
        int tamanioGrafica = (votosCandidato * tamanioMaxGrafica) / votosTotales;

        // Imprime la gráfica
        while(tamanioGrafica > 0) {

            System.out.print("*");

            tamanioGrafica--;

        }

        // Salto de línea
        System.out.println("");

    }

}
