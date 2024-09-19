package mx.unam.dgtic.models;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Recommendation {
    private String item;
    private double score;

    public Recommendation(String item, double score) {
        this.item = item;
        this.score = score;
    }

    public String getItem() {
        return item;
    }

    public double getScore() {
        return score;
    }

    public void displayDetails(){
        System.out.println("Item: "+item+" Score: "+score);
    }


}
