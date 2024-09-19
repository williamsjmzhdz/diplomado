package mx.unam.dgtic;

import mx.unam.dgtic.prototype.Employee;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class HalfTimeEmployee extends Employee {
    private double salary;

    public HalfTimeEmployee(String name, String department, double salary) {
        super(name, department);
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public Employee clone() {
        return new HalfTimeEmployee(getName(),getDepartment(),getSalary());
    }
}
