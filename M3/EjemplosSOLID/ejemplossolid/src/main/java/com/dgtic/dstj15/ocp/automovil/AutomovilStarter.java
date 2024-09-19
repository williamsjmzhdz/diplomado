package com.dgtic.dstj15.ocp.automovil;

import com.dgtic.dstj15.ocp.automovil.entity.Automovil;
import com.dgtic.dstj15.ocp.automovil.repository.AutomovilRepositoryImpl;
import com.dgtic.dstj15.ocp.automovil.service.AutomovilService;
import com.dgtic.dstj15.ocp.automovil.service.AutomovilServiceImpl;

public class AutomovilStarter {
    public static void main(String[] args) {
        AutomovilService service = new AutomovilServiceImpl(new AutomovilRepositoryImpl());

        Automovil mazda = new Automovil("Mazda");
        Automovil tesla = new Automovil("Tesla");
        Automovil jeep = new Automovil("Jeep");

        service.mostrarInformacion(tesla);
        service.arrancarMotor(tesla);

    }
}
