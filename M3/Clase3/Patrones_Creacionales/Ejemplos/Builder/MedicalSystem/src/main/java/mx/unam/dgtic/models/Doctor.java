package mx.unam.dgtic.models;

import lombok.Builder;
import mx.unam.dgtic.builders.doctor.DoctorBuilder;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
@Builder
public class Doctor {
    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String uuid;

    public Doctor(String name, int age, String speciality, String dni, String uuid) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
        this.dni = dni;
        this.uuid = uuid;
    }

    public String name() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return this;
    }

    public int age() {
        return age;
    }

    public Doctor setAge(int age) {
        this.age = age;
        return this;
    }

    public String speciality() {
        return speciality;
    }

    public Doctor setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public String dni() {
        return dni;
    }

    public Doctor setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String uuid() {
        return uuid;
    }

    public Doctor setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public static DoctorBuilder doctorBuilder() {
        return new DoctorBuilder();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", speciality='" + speciality + '\'' +
                ", dni='" + dni + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
