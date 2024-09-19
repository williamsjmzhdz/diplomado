package mx.unam.dgtic.utils;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.MedicalRecord;
import mx.unam.dgtic.models.Patient;

import java.time.LocalDate;
import java.util.UUID;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DummyUtils {
    public static Patient getPatientDummy(){
        return new Patient.Builder()
                .name("Maria")
                .age(12)
                .location("CANADA")
                .dni("DNI123123")
                .build();
    }

    public static Doctor getDoctorDummy(){
        return new Doctor.Builder()
                .name("Jhon Doe")
                .age(32)
                .speciality("General")
                .uuid(UUID.randomUUID().toString())
                .dni("DNI123")
                .build();
    }

    public static MedicalRecord getMedicalRecordDummy(Patient patient, Doctor doctor){
        return new MedicalRecord.Builder()
                .doctor(doctor)
                .patient(patient)
                .prescription("Prescription")
                .diagnosis("NA")
                .date(LocalDate.now())
                .build();
    }
}
