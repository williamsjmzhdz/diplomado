package com.unam.dgtic;

import com.unam.dgtic.observer.DoctorDevice;
import com.unam.dgtic.observer.EmergencyNotificationSystem;
import com.unam.dgtic.observer.HealthObserver;
import com.unam.dgtic.observer.PatientDevice;
import com.unam.dgtic.publisher.HealthPublisher;
import com.unam.dgtic.publisher.Publisher;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 ** @author: hxa.dev
 ***/
public class EmbeddedMedicalSmartPro {
    public static void run(String version) {
        synchronized (version) {
            try {
                System.out.println("Embedded Medical Smart Pro - Running Version " + version);
                // Creamos un nuevo publicador Health
                Publisher publisher = new HealthPublisher();

                // Cramos nuestros observers.
                HealthObserver patientDevice1 = new PatientDevice("ALEX GOMEZ PHONE");
                HealthObserver patientDevice2 = new PatientDevice("ALEX GOMEZ TABLET");
                HealthObserver doctorPatient = new DoctorDevice("ALEX GOMEZ", "Dr. JHON PHONE");
                HealthObserver emergencySystem = new EmergencyNotificationSystem("EMERGENCY");

                // Subscribimos nuestros observers al publicador.
                publisher.subscribe(doctorPatient);
                publisher.subscribe(emergencySystem);

                // Comenzamos a publicar mensajes para que los suscriptores lo reciban y cambien
                // su estado.

                detectAnomaly(publisher);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void detectAnomaly(Publisher publisher) {
        final int MIN_HEARTH_RATE = 60;
        final int MAX_HEARTH_RATE = 100;

        int currentHearthRate = MIN_HEARTH_RATE + 30;

        try {
            while (currentHearthRate > MIN_HEARTH_RATE && currentHearthRate < MAX_HEARTH_RATE) {
                Thread.sleep(1000);
                currentHearthRate = MIN_HEARTH_RATE + (int) (Math.random() * (MAX_HEARTH_RATE - MIN_HEARTH_RATE));
                System.out.println("Current hearth rate: " + currentHearthRate);
            }

            if (currentHearthRate >= MAX_HEARTH_RATE) {
                for (int i = 0; i < 5; i++) {
                    publisher.detectAnomaly("BRADYCARDIA");
                    Thread.sleep(100);
                }
            } else if (currentHearthRate <= MIN_HEARTH_RATE) {
                for (int i = 0; i < 5; i++) {
                    publisher.detectAnomaly("TACHYCARDIA");
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
