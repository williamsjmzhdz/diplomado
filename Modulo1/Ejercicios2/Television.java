import java.util.Arrays;

/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 18/05/2024
 * Descripción: Clase que representa una televisión con atributos como tamaño, resolución, volumen, brillo, canal y estado de encendido. Incluye métodos para manipular estos atributos y realizar acciones como encender/apagar, ajustar el volumen y cambiar canales.
 */

public class Television implements IcontrolesUniversales {

    // Definición de atributos
    private float tamanio; // Tamaño de la televisión en pulgadas
    private short resolucionHorizontal; // Resolución horizontal de la televisión
    private short resolucionVertical; // Resolución vertical de la televisión
    private byte volumen; // Volumen de la televisión
    private byte volumenAuxiliar; // Volumen auxiliar para silenciar y restaurar el volumen
    private byte brillo; // Brillo de la televisión
    private short canal; // Canal actual de la televisión
    private boolean encendido; // Estado de encendido/apagado de la televisión
    private short[] listaCanales = {0, 2, 5, 7, 11, 13}; // Lista de canales disponibles

    /**
     * Constructor por defecto que inicializa los atributos de la televisión con valores predeterminados.
     */
    public Television() {
        this.setTamanio(0);
        this.setResolucionHorizontal((short) 1920);
        this.setResolucionVertical((short) 1080);
        this.setVolumen((byte) 50);
        this.setBrillo((byte) 50);
        this.setCanal((short) 0);
        this.setEncendido(false);
    }

    // Métodos getters y setters
    public float getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public short getResolucionHorizontal() {
        return this.resolucionHorizontal;
    }

    public void setResolucionHorizontal(short resolucionHorizontal) {
        this.resolucionHorizontal = resolucionHorizontal;
    }

    public short getResolucionVertical() {
        return this.resolucionVertical;
    }

    public void setResolucionVertical(short resolucionVertical) {
        this.resolucionVertical = resolucionVertical;
    }

    public byte getVolumen() {
        return this.volumen;
    }

    private void setVolumen(byte volumen) {
        if (volumen >= 0 && volumen <= 100) {
            this.volumen = volumen;
        }
    }

    private byte getVolumenAuxiliar() {
        return this.volumenAuxiliar;
    }

    private void setVolumenAuxiliar(byte volumen) {
        this.volumenAuxiliar = volumen;
    }

    public byte getBrillo() {
        return this.brillo;
    }

    public void setBrillo(byte brillo) {
        if (brillo >= 0 && brillo <= 100) {
            this.brillo = brillo;
        }
    }

    public short getCanal() {
        return canal;
    }

    public void setCanal(short canal) {
        this.canal = canal;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    /**
     * Método para subir el volumen de la televisión en una unidad.
     */
    public void subirVolumen() {
        this.setVolumen((byte) (this.getVolumen() + 1));
    }

    /**
     * Método para bajar el volumen de la televisión en una unidad.
     */
    public void bajarVolumen() {
        this.setVolumen((byte) (this.getVolumen() - 1));
    }

    /**
     * Método para encender la televisión.
     */
    public boolean encenderApagar() {
        this.setEncendido(!encendido);
        return encendido;
    }

    /**
     * Método para silenciar o restaurar el volumen de la televisión.
     */
    public void silenciar() {
        if (this.getVolumen() == 0) {
            this.setVolumen(this.getVolumenAuxiliar());
        } else {
            this.setVolumenAuxiliar(this.getVolumen());
            this.setVolumen((byte) 0);
        }
    }

    /**
     * Método para cambiar al siguiente canal en la lista de canales.
     */
    public void canalMas() {
        for (int i = 0; i < listaCanales.length; i++) {
            if (listaCanales[i] == this.getCanal()) {
                this.setCanal(
                        ((i + 1) >= listaCanales.length)
                                ? (short) 0
                                : listaCanales[i + 1]
                );
                break;
            }
        }
    }

    /**
     * Método para cambiar al canal anterior en la lista de canales.
     */
    public void canalMenos() {
        for (int i = 0; i < listaCanales.length; i++) {
            if (listaCanales[i] == this.getCanal()) {
                this.setCanal(
                        ((i - 1) < 0)
                                ? (short) listaCanales[listaCanales.length - 1]
                                : listaCanales[i - 1]
                );
                break;
            }
        }
    }

    /**
     * Método sobrescrito para obtener una representación en cadena de la televisión.
     *
     * @return Una cadena que representa la televisión.
     */
    @Override
    public String toString() {
        return "Television{" +
                "tamanio=" + tamanio +
                ", resolucionHorizontal=" + resolucionHorizontal +
                ", resolucionVertical=" + resolucionVertical +
                ", volumen=" + volumen +
                ", volumenAuxiliar=" + volumenAuxiliar +
                ", brillo=" + brillo +
                ", canal=" + canal +
                ", encendido=" + encendido +
                ", listaCanales=" + Arrays.toString(listaCanales) +
                '}';
    }

    @Override
    public void imprimeStatus() {
        // IcontrolesUniversales.super.imprimeStatus(); // Ejecuta el método default original de la interfaz.
        System.out.println("Muestro el estatus de la televisión.");
    }
}


    /** PENDIENTES
     * + Television() ✅
     * + (setters y getters) ✅
     * + toString() ✅
     * + encenderApagar() ✅
     * + subirVolumen() ✅
     * + silenciar() ✅
     * + bajarVolumen() ✅
     * + canalMas() ✅
     * + canalMenos() ✅
     * + subirBrillo() 💻
     * + bajarBrillo() 💻

     * */
