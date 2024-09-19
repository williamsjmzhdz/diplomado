package mx.unam.dgtic;

import mx.unam.dgtic.prototype.Employee;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String name, String department, double salary) {
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
        return new FullTimeEmployee(getName(),getDepartment(),getSalary());
    }

    @Override
    public String toString() {
        return super.toString()+
                " salary=" + salary +
                '}';
    }
}
