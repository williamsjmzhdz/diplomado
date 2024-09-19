package mx.unam.dgtic.models;

import javax.print.Doc;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Doctor {
    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String uuid;

    public Doctor(Builder builder) {
        this.name=builder.name;
        this.age=builder.age;
        this.speciality=builder.speciality;
        this.dni=builder.dni;
        this.uuid=builder.uuid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getDni() {
        return dni;
    }

    public String getUuid() {
        return uuid;
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

    public static class Builder{
        private String name;
        private int age;
        private String speciality;
        private String dni;
        private String uuid;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Doctor build(){
            return new Doctor(this);
        }
    }

}
