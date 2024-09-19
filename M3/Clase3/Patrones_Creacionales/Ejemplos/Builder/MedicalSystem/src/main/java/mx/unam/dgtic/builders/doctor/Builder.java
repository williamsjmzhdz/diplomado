package mx.unam.dgtic.builders.doctor;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.Patient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Builder {
    DoctorBuilder fullName(String name);
    DoctorBuilder age(int age);
    DoctorBuilder speciality(String speciality);
    DoctorBuilder dni(String dni);

    DoctorBuilder uuid(String uuid);

    Doctor getResult();

}
