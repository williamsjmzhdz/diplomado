package dgtic.inicio;

import dgtic.modelo.*;

public class MetodoTres {

    public static void main(String[] args) {

        Profesor profesor = new Profesor();
        Responsabilidades explicarClases = new ExplicarClases();
        Responsabilidades calificar = new Calificar();
        Responsabilidades reportes = new Reportes();

        ((Calificar) explicarClases).calificar();

        profesor.getResponsabilidades().add(explicarClases);
        profesor.getResponsabilidades().add(calificar);
        profesor.getResponsabilidades().add(reportes);

        for (Responsabilidades responsabilidad : profesor.getResponsabilidades())
            responsabilidad.realizar();

    }

}
