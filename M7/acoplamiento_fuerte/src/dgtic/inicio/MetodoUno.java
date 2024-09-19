package dgtic.inicio;

import dgtic.modelo.Profesor;
import dgtic.modelo.Responsabilidades;

public class MetodoUno {

    public static void main(String[] args) {

        Profesor profesor = new Profesor();
        Responsabilidades responsabilidades = new Responsabilidades();
        profesor.setResponsabilidades(responsabilidades);

    }

}
