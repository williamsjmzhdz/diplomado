package dgtic.core.servicio;

import dgtic.core.modelo.Persona;

public class Servicio {

    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "persona=" + persona +
                '}';
    }
}
