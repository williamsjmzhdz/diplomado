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
public class MedicalRecordBuilder implements Builder{
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
    private String diagnosis;
    private String prescription;

    /**
     * @param doctor
     */
    @Override
    public void doctor(Doctor doctor) {
        this.doctor=doctor;
    }

    /**
     * @param patient
     */
    @Override
    public void patient(Patient patient) {
        this.patient=patient;
    }

    /**
     * @param date
     */
    @Override
    public void date(LocalDate date) {
        this.date=date;
    }

    /**
     * @param diagnosis
     */
    @Override
    public void diagnosis(String diagnosis) {
        this.diagnosis=diagnosis;
    }

    /**
     * @param prescription
     */
    @Override
    public void prescription(String prescription) {
        this.prescription=prescription;
    }

    /**
     * @return
     */
    @Override
    public MedicalRecord getResult() {
        return new MedicalRecord(doctor,patient,date,diagnosis,prescription);
    }
}
