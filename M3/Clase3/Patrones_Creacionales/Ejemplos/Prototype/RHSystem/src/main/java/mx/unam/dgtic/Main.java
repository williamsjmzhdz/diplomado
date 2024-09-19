package mx.unam.dgtic;

import mx.unam.dgtic.prototype.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Main {
    public static void main(String[] args) {

        FullTimeEmployee prototypeFullEmployee = new FullTimeEmployee("GENERIC","GENERIC",0);
        HalfTimeEmployee prototypeHalfEmployee = new HalfTimeEmployee("GENERIC","GENERIC",0);

        FullTimeEmployee nacho= (FullTimeEmployee) prototypeFullEmployee.clone();
        nacho.setName("Nacho");
        nacho.setSalary(23432);
        nacho.setDepartment("IT");

        HalfTimeEmployee laura= (HalfTimeEmployee) prototypeHalfEmployee.clone();
        laura.setName("Laura");
        laura.setDepartment("IT");
        laura.setSalary(30000);

        List<Employee> employess=List.of(nacho,laura);

        employess.stream().forEach(System.out::println);
    }
}