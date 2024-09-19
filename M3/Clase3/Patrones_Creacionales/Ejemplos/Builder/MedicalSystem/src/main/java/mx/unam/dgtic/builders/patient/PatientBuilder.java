package mx.unam.dgtic.builders.patient;

import mx.unam.dgtic.models.Patient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class PatientBuilder implements Builder{
    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String location;


    @Override
    public void fullName(String name) {
        this.name=name;
    }

    @Override
    public void age(int age) {
        this.age=age;
    }

    @Override
    public void dni(String dni) {
        this.dni=dni;
    }

    @Override
    public void location(String location) {
        this.location=location;
    }

    /**
     * @return
     */
    @Override
    public Patient getResult() {
        return new Patient(name,age,speciality,dni,location);
    }

}
