package dgtic.core.servicio;

public class Servicio {

    private static Servicio servicio = new Servicio();

    private Servicio() {}

    public static Servicio getInstance() {
        return servicio;
    }

}
