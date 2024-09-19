package mx.unam.dgtic.builders.doctor;

import mx.unam.dgtic.models.Doctor;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DoctorBuilder implements Builder{
    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String uuid;

    @Override
    public DoctorBuilder fullName(String name) {
        this.name=name;
        return this;
    }

    @Override
    public DoctorBuilder age(int age) {
        this.age=age;
        return this;
    }

    @Override
    public DoctorBuilder speciality(String speciality) {
        this.speciality=speciality;
        return this;
    }

    @Override
    public DoctorBuilder dni(String dni) {
        this.dni=dni;
        return this;
    }

    @Override
    public DoctorBuilder uuid(String uuid) {
        this.uuid=uuid;
        return this;
    }

    /**
     * @return
     */
    @Override
    public Doctor getResult() {
        return new Doctor(name,age,speciality,dni,uuid);
    }
}
