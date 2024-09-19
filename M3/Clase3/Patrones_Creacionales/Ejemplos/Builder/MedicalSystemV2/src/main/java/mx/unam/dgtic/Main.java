package mx.unam.dgtic;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.MedicalRecord;
import mx.unam.dgtic.models.Patient;
import mx.unam.dgtic.service.MedicalService;
import mx.unam.dgtic.service.MedicalServiceImpl;

import java.time.LocalDate;
import java.util.UUID;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var doctor= new Doctor.Builder()
                .name("Jhon Doe")
                .age(32)
                .speciality("General")
                .uuid(UUID.randomUUID().toString())
                .dni("DNI123")
                .build();
        var patient=new Patient.Builder()
                .name("Maria")
                .age(12)
                .location("CANADA")
                .dni("DNI123123")
                .build();

        var record=new MedicalRecord.Builder()
                .doctor(doctor)
                        .patient(patient)
                                .prescription("Prescription")
                                        .diagnosis("NA")
                                                .date(LocalDate.now())
                                                        .build();

        MedicalService medicalService=new MedicalServiceImpl();
        medicalService.createAppointment(record);
    }
}