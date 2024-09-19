package com.dgtic.dstj15.srp.calculadora;

/**
 * Esta calculadora se encuentra sobrecargada de operaciones de una calculadora basica y una calculadora cientifica
 * La estructura de esta clase tiene una cohesion baja, por lo que necesitamos implementar el Patron Principio de Responsabilidad
 * para poder separar las operaciones de una calculadora basica y una calculadora cientifica.
 * @author hxa.dev
 */
public class Calculadora {
    public double sumar(double a, double b){
        return a+b;
    }

    public double restar(double a, double b){
        return a-b;
    }

    public double multiplicar(double a, double b){
        return a*b;
    }

    public double dividir(double a, double b){
        return a/b;
    }

    public double potencia(double a, double b){
        return Math.pow(a, b);
    }

    public double raiz(double a){
        return Math.sqrt(a);
    }

    public double factorial(double a){
        return 1;
    }

    public double seno(double a){
        return Math.sin(a);
    }

    public double coseno(double a){
        return Math.cos(a);
    }

    public double tangente(double a){
        return Math.tan(a);
    }

    public double logaritmoNatural(double a){
        return Math.log(a);
    }

    public double logaritmoBase10(double a){
        return Math.log10(a);
    }

    public double logaritmoBase2(double a){
        return Math.log(a)/Math.log(2);
    }

    public double raizCubica(double a){
        return Math.cbrt(a);
    }

    


}
