package mx.unam.dgtic.strategy;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class TaxStrategyUSA implements InvoiceTaxStrategy{
    @Override
    public double calcTaxes(double amount) {
        return amount*0.8;
    }
}
