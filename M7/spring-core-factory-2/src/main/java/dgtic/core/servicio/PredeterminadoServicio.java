package dgtic.core.servicio;

public class PredeterminadoServicio {
    private static EmpleadoServicio empleadoServicio = new EmpleadoServicioImpl();
    private static ReporteEmpleadoServicio reporteEmpleadoServicio = new ReporteEmpleadoImpl();

    private PredeterminadoServicio() {}

    public static EmpleadoServicio getEmpleadoServicio() {
        return empleadoServicio;
    }

    public static ReporteEmpleadoServicio getReporteEmpleadoServicio() {
        return reporteEmpleadoServicio;
    }
}
