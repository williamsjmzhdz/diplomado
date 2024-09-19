package mx.unam.dgtic;

import mx.unam.dgtic.builders.medicalRecord.MedicalRecordBuilder;
import mx.unam.dgtic.builders.doctor.DoctorBuilder;
import mx.unam.dgtic.builders.patient.PatientBuilder;
import mx.unam.dgtic.director.Director;
import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.Patient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class Main {
    public static void main(String[] args) {
        Director director=new Director();
        PatientBuilder patientBuilder=new PatientBuilder();
        MedicalRecordBuilder medicalRecordBuilder=new MedicalRecordBuilder();

        director.buildPatient(patientBuilder);
        director.buildMedicalRecord(medicalRecordBuilder);

        System.out.println(patientBuilder.getResult());
        System.out.println(medicalRecordBuilder.getResult());


        DoctorBuilder db = new DoctorBuilder();
        Doctor doctor = db.age(5).speciality("Software").getResult();
        System.out.println(doctor);

    }
}