/**
 * Autor: Francisco Williams Jiménez Hernández
 * Fecha: 17/05/2024
 * Descripción: Clase que representa una cuenta bancaria con métodos para realizar operaciones básicas.
 */

public class CuentaBancaria {

    // Atributos
    private String numeroCuenta;
    private String titular;
    private String tipoCuenta; // Crédito, Débito, Inversión
    private double saldo;
    private String fechaApertura;

    // Constructor por defecto
    public CuentaBancaria() {
        this.numeroCuenta = "S/C";
        this.titular = "Sin titular";
        this.tipoCuenta = "Débito";
        this.saldo = 0;
        this.fechaApertura = "01/01/2000";
    }

    // Constructor sobrecargado que inicializa la cuenta usando un número de cuenta
    public CuentaBancaria(String cuenta) {
        this(); // Llama al constructor por defecto
        if (cuenta.equals("12345")) {
            this.numeroCuenta = cuenta;
            this.titular = "Hugo";
            this.tipoCuenta = "Crédito";
            this.saldo = 111;
            this.fechaApertura = "01/01/2001";
        }
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Método para depositar dinero en la cuenta
    public boolean depositar(double cantidad) {
        if(cantidad > 0) {
            this.setSaldo(this.getSaldo() + cantidad);
            // Aquí debería estar la actualización en la base de datos
            return true;
        }
        return false;
    }

    // Método para retirar dinero de la cuenta
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.setSaldo(this.getSaldo() - monto);
            // Aquí debería estar la actualización en la base de datos
            return true;
        }
        return false;
    }

    // Método para transferir dinero a otra cuenta
    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {
        // 1.- Retirar el monto de la cuenta origen
        this.retirar(monto);

        // 2.- Depositar el monto en la cuenta destino
        cuentaDestino.depositar(monto);

        return true;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura='" + fechaApertura + '\'' +
                '}';
    }
}
