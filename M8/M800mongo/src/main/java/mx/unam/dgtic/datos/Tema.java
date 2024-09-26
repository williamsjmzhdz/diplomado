package mx.unam.dgtic.datos;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
public class Tema {

    private String tema;
    private double puntos;

    public Tema() {
    }

    public Tema(String tema, double puntos) {
        this.tema = tema;
        this.puntos = puntos;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "tema='" + tema + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
