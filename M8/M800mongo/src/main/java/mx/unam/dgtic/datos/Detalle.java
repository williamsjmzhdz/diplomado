package mx.unam.dgtic.datos;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
public class Detalle {

    private String area;
    private double plan;

    public Detalle() {
    }

    public Detalle(String area, double plan) {
        this.area = area;
        this.plan = plan;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getPlan() {
        return plan;
    }

    public void setPlan(double plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "area='" + area + '\'' +
                ", plan=" + plan +
                '}';
    }
}
