/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 31/05/2025
 * Descripción: Clase Cliente de la práctica 3
 */

public class Cliente extends Persona {
    private int numeroCliente;
    private int nivel;

    public Cliente() {
        super();
        setNumeroCliente(0);
        setNivel(1);
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        if(numeroCliente >= 0) {
            this.numeroCliente = numeroCliente;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if(nivel >= 1 && nivel <= 3) {
            this.nivel = nivel;
        }
    }

    @Override
    public String toString() {
        return "Cliente " + numeroCliente + ": " + super.getNombre() + ", nivel = " + nivel;
    }
}
