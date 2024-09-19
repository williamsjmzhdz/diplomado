package mx.unam.dgtic.service;

import mx.unam.dgtic.models.MedicalRecord;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MedicalServiceImpl implements MedicalService {

    @Override
    public void createAppointment(MedicalRecord record) {
        System.out.println("Creando Cita");
        System.out.println("Fecha: "+record.getDate().toString());
        System.out.println("Paciente: "+record.getPatient().getName());
        System.out.println("Doctor: "+record.getDoctor().getName());
    }
}
