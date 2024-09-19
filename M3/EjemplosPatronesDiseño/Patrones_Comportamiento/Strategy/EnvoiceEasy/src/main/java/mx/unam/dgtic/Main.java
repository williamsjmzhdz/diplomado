package mx.unam.dgtic;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

import mx.unam.dgtic.context.TaxStrategyContext;
import mx.unam.dgtic.strategy.InvoiceTaxStrategy;
import mx.unam.dgtic.strategy.TaxStrategyJAM;
import mx.unam.dgtic.strategy.TaxStrategyMX;
import mx.unam.dgtic.strategy.TaxStrategySPAIN;
import mx.unam.dgtic.strategy.TaxStrategyUSA;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    enum Countries{
        MX,
        USA,
        JAMAICA,
        ARGENTINA,
        SPAIN,
        INDIA
    }

    static Map<Countries,InvoiceTaxStrategy> strategies = new EnumMap<>(Countries.class);

    static{
        strategies.put(Countries.MX,new TaxStrategyMX());
        strategies.put(Countries.USA,new TaxStrategyUSA());
        strategies.put(Countries.JAMAICA,new TaxStrategyJAM());
        strategies.put(Countries.SPAIN,new TaxStrategySPAIN());
    }

    public static void main(String[] args) {

        System.out.println("Enter amount: ");
        double originalAmount=new Scanner(System.in).nextDouble();

        System.out.println("Enter country: ");
        System.out.println("MX, USA, JAMAICA, ARGENTINA, SPAIN, INDIA");
        Countries country=Countries.valueOf(new Scanner(System.in).nextLine());

        TaxStrategyContext context=new TaxStrategyContext();

        InvoiceTaxStrategy strategy=strategies.get(country);
        if(strategy!=null){
            context.setStrategy(strategy);
        }else{
            throw new RuntimeException("No implemented");
        }

        // Break OCP
        /*switch (country){
            case MX:
                context.setStrategy(new TaxStrategyMX());
                break;
            case SPAIN:
                context.setStrategy(new TaxStrategySPAIN());
                break;
            case USA:
                context.setStrategy(new TaxStrategyUSA());
                break;
            case JAMAICA:
                context.setStrategy(new TaxStrategyJAM());
                break;
            default:
                throw new RuntimeException("No implemented");
        }*/

        double totalWithTaxes= context.calcTotalWithTaxes(originalAmount);

        System.out.println("Location: "+country.name());
        System.out.println("Amount: "+originalAmount);
        System.out.println("Amount with taxes: "+totalWithTaxes);
    }
}