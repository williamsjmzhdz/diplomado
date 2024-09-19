package com.unam.dgtic.publisher;

import com.unam.dgtic.observer.HealthObserver;

import java.util.ArrayList;
import java.util.List;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class HealthPublisher implements Publisher{
    private List<HealthObserver> observers;
    

    public HealthPublisher() {
        observers=new ArrayList<>();
    }

    @Override
    public void subscribe(HealthObserver observer){
        observers.add(observer);
    }

    @Override
    public void unsubscribe(HealthObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(String message){
        for(HealthObserver observer:observers){
            observer.update(message);
        }
    }

    public void detectAnomaly(String anomaly){
        notifyObservers("Anomaly detected: "+anomaly);
    }
}
