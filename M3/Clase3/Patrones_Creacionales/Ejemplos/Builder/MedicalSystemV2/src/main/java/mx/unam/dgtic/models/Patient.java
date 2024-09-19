package mx.unam.dgtic.models;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Patient {

    private String name;
    private int age;
    private String dni;
    private String location;

    public Patient(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.dni = builder.dni;
        this.location = builder.location;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDni() {
        return dni;
    }

    public String getLocation() {
        return location;
    }

    public static class Builder{
        private String name;
        private int age;
        private String dni;
        private String location;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }


        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}
