package mx.unam.dgtic.builders.patient;

import mx.unam.dgtic.models.Patient;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Builder {
    void fullName(String name);
    void age(int age);
    void dni(String dni);
    void location(String location);
    Patient getResult();
}
