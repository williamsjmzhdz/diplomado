import java.util.Objects;

/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 17/05/2024
 * Descripción: Clase que representa una casa con atributos básicos y métodos para su gestión.
 */

public class Casa {

    // Atributos
    private int superficieTerreno; // Superficie del terreno en metros cuadrados
    private int superficieConstruccion; // Superficie de construcción en metros cuadrados
    private double precio; // Precio de la casa
    private String color = "Rojo"; // Color de la casa, con valor inicial "Rojo". El valor por default para Strings es null.
    private boolean comprado; // Estado de la casa, si está comprada o no

    public int getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(int superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public int getSuperficieConstruccion() {
        return superficieConstruccion;
    }

    public void setSuperficieConstruccion(int superficieConstruccion) {
        if(superficieConstruccion > 50) {
            this.superficieConstruccion = superficieConstruccion;
        }

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casa casa)) return false;
        return getSuperficieTerreno() == casa.getSuperficieTerreno() && getSuperficieConstruccion() == casa.getSuperficieConstruccion() && Double.compare(getPrecio(), casa.getPrecio()) == 0 && isComprado() == casa.isComprado() && Objects.equals(getColor(), casa.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuperficieTerreno(), getSuperficieConstruccion());
    }

    // Métodos
    // Los métodos para vender, rentar, agregar, dar de baja, cambiar propietario, pintar
    // no están implementados en este código, pero se mencionan como posibles funcionalidades
}
