package com.dgtic.dstj15.srp.automovil;

import com.dgtic.dstj15.srp.automovil.entity.Automovil;
import com.dgtic.dstj15.srp.automovil.service.AutomovilService;
import com.dgtic.dstj15.srp.automovil.service.AutomovilServiceImpl;

public class App {
    public static void main(String[] args) {
        AutomovilService service = new AutomovilServiceImpl();

        Automovil mazda = new Automovil("Mazda");
        Automovil tesla = new Automovil("Tesla");
        Automovil jeep = new Automovil("Jeep");

        service.mostrarInformacion(jeep);
        service.acelerar(jeep);


    }
}
