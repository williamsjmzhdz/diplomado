package dgtic.core.repositorio;

import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    public static List<Estudiante> estudiantes=new ArrayList<>();
    static {
        Estudiante est=new Estudiante("123","Rosa",20);
        est.setMaterias(new Materia(1l,"Cálculo",9),new Materia(2l,"Programación",10),
                new Materia(3l,"Lógica",10));
        estudiantes.add(est);
        est=new Estudiante("124","Tomas",22);
        est.setMaterias(new Materia(2l,"Programación",10),
                new Materia(3l,"Lógica",10));

        estudiantes.add(est);
        est=new Estudiante("125","Mario",20);
        est.setMaterias(new Materia(1l,"Cálculo",9),new Materia(4l,"Circuitos Lógicos",10),
                new Materia(5l,"Lógica de Autómatas",10));
        estudiantes.add(est);
        est=new Estudiante("126","Esmeralda",22);
        est.setMaterias(new Materia(4l,"Circuitos Lógicos",10),
                new Materia(5l,"Lógica de Autómatas",10));
        estudiantes.add(est);
    }
}
