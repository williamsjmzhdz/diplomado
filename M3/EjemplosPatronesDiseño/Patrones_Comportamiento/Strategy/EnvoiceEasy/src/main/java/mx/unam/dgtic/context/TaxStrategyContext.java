package mx.unam.dgtic.context;

import mx.unam.dgtic.strategy.InvoiceTaxStrategy;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class TaxStrategyContext {
    private InvoiceTaxStrategy strategy;

    public void setStrategy(InvoiceTaxStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcTotalWithTaxes(double amount){
        double tax=strategy.calcTaxes(amount);
        return amount+tax;
    }
}
