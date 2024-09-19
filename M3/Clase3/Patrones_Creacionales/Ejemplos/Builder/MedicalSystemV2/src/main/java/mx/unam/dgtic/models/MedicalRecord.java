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

    public MedicalRecord(Builder builder) {
        this.doctor = builder.doctor;
        this.patient = builder.patient;
        this.date = builder.date;
        this.diagnosis = builder.diagnosis;
        this.prescription = builder.prescription;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public static class Builder{
        private Doctor doctor;
        private Patient patient;
        private LocalDate date;
        private String diagnosis;
        private String prescription;

        public Builder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Builder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder diagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        public Builder prescription(String prescription) {
            this.prescription = prescription;
            return this;
        }

        public MedicalRecord build(){
            return new MedicalRecord(this);
        }
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
