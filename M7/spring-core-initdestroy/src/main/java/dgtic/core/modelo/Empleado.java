package dgtic.core.modelo;

import org.springframework.beans.factory.InitializingBean;

public class Empleado implements InitializingBean {

    private String nombre;
    private Integer edad;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Iniciando empleado...");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public void limpiar() {
        System.out.println("Liberando recursos de empleado...");
    }
}
