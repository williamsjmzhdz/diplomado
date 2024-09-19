package mx.unam.dgtic.builders.medicalRecord;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.MedicalRecord;
import mx.unam.dgtic.models.Patient;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Builder {
    void doctor(Doctor doctor);
    void patient(Patient patient);
    void date(LocalDate date);
    void diagnosis(String diagnosis);
    void prescription(String prescription);

    MedicalRecord getResult();

}
