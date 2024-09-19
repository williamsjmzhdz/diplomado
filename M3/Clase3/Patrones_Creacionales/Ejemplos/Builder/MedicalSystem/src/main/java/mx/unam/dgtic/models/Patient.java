package mx.unam.dgtic.models;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Patient {

    private String name;
    private int age;
    private String speciality;
    private String dni;
    private String location;

    public Patient(String name, int age, String speciality, String dni, String location) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
        this.dni = dni;
        this.location = location;
    }

    public String name() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public int age() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    public String speciality() {
        return speciality;
    }

    public Patient setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public String dni() {
        return dni;
    }

    public Patient setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String location() {
        return location;
    }

    public Patient setLocation(String location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", speciality='" + speciality + '\'' +
                ", dni='" + dni + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
