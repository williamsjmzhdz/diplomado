public class Producto {
    private int codigo;
    private String nombre;
    private double precio;

    public Producto() {
        this.codigo = -1;
    }

    public Producto(int codigo) {
        this();

        switch (codigo) {
            case 1:
                this.setCodigo(codigo);
                this.setNombre("Cuaderno");
                this.setPrecio(50.00);
                break;
            case 3:
                this.setCodigo(codigo);
                this.setNombre("Pluma");
                this.setPrecio(13.00);
                break;
            case 5:
                this.setCodigo(codigo);
                this.setNombre("Regla");
                this.setPrecio(16.50);
                break;
            case 8:
                this.setCodigo(codigo);
                this.setNombre("Goma");
                this.setPrecio(7.00);
                break;
            case 9:
                this.setCodigo(codigo);
                this.setNombre("Lápiz");
                this.setPrecio(7.50);
                break;
            case 11:
                this.setCodigo(codigo);
                this.setNombre("Carpeta");
                this.setPrecio(126.00);
                break;
            case 22:
                this.setCodigo(codigo);
                this.setNombre("Tinta");
                this.setPrecio(554.00);
                break;
            case 99:
                this.setCodigo(codigo);
                this.setNombre("Sobres");
                this.setPrecio(32.00);
                break;
            case 123:
                this.setCodigo(codigo);
                this.setNombre("Folder");
                this.setPrecio(5.00);
                break;
            default:
                break;
        }

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.nombre + " ($ " + this.precio + " )";
    }
}
