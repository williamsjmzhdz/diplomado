package mx.unam.dgtic.datos;

public class Edad {

    private double anios;
    private double meses;
    private double dias;

    public Edad() {
    }

    public Edad(double anios, double meses, double dias) {
        this.anios = anios;
        this.meses = meses;
        this.dias = dias;
    }

    public double getAnios() {
        return anios;
    }

    public void setAnios(double anios) {
        this.anios = anios;
    }

    public double getMeses() {
        return meses;
    }

    public void setMeses(double meses) {
        this.meses = meses;
    }

    public double getDias() {
        return dias;
    }

    public void setDias(double dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Edad{" +
                "anios=" + anios +
                ", meses=" + meses +
                ", dias=" + dias +
                '}';
    }
}
