package mx.unam.dgtic.director;

import mx.unam.dgtic.builders.doctor.Builder;

import java.util.UUID;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Director {
    public void buildDoctor(Builder builder){
        builder.uuid(UUID.randomUUID().toString());
        builder.age(21);
        builder.fullName("Jhon Doe");
        builder.speciality("General Medicine");
    }
    public void buildPatient(mx.unam.dgtic.builders.patient.Builder builder){
        builder.age(11);
        builder.fullName("Mary Doe");
        builder.dni("ASDZXC");
        builder.location("CANADA");
    }

    public void buildMedicalRecord(mx.unam.dgtic.builders.medicalRecord.Builder builder){

    }
}
