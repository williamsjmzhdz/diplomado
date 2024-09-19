package mx.unam.dgtic.service;

import mx.unam.dgtic.models.Doctor;
import mx.unam.dgtic.models.MedicalRecord;
import mx.unam.dgtic.models.Patient;
import mx.unam.dgtic.utils.DummyUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class MedicalServiceTest {

    private MedicalService medicalService;
    private MedicalRecord medicalRecord;
    private Patient patient;
    private Doctor doctor;


    @Before
    public void setUp() {
        medicalService=new MedicalServiceImpl();
        doctor=DummyUtils.getDoctorDummy();
        patient=DummyUtils.getPatientDummy();
        medicalRecord= DummyUtils.getMedicalRecordDummy(patient,doctor);
    }

    @Test
    public void givenMedicalRecordWhenHasPatientAndDoctorThenValidateCreation(){
        //Given
        MedicalService medicalService1=medicalService;


        //When
        assumeTrue(medicalRecord!=null && medicalRecord.getDoctor()!=null);

        //Then
        assertNotNull(doctor);
        assertNotNull(patient);
        assertNotNull(medicalRecord);
        assertTrue(medicalRecord.getDoctor().equals(doctor));
        assertTrue(medicalRecord.getPatient().equals(patient));
        medicalService.createAppointment(medicalRecord);
    }
}