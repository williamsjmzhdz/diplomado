package mx.unam.dgtic.models;

import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MedicalRecord {
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
    private String diagnosis;
    private String prescription;

    public MedicalRecord(Doctor doctor, Patient patient, LocalDate date, String diagnosis, String prescription) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public Doctor doctor() {
        return doctor;
    }

    public MedicalRecord setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public Patient patient() {
        return patient;
    }

    public MedicalRecord setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public LocalDate date() {
        return date;
    }

    public MedicalRecord setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String diagnosis() {
        return diagnosis;
    }

    public MedicalRecord setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public String prescription() {
        return prescription;
    }

    public MedicalRecord setPrescription(String prescription) {
        this.prescription = prescription;
        return this;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}
