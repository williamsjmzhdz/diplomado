package com.unam.dgtic.publisher;

import com.unam.dgtic.observer.HealthObserver;

import java.util.ArrayList;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Publisher {
    public void subscribe(HealthObserver observer);

    public void unsubscribe(HealthObserver observer);

    public void detectAnomaly(String anomaly);
}
