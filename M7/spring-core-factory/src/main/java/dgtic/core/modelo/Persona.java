package dgtic.core.modelo;

public class Persona {

    private String nombre;
    private FabricaCoches coche;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FabricaCoches getCoche() {
        return coche;
    }

    public void setCoche(FabricaCoches coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
