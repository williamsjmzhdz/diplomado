package mx.unam.dgtic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mx.unam.dgtic.collection.ConcreteRecommendationCollection;
import mx.unam.dgtic.iterator.RecommendationIterator;
import mx.unam.dgtic.models.Recommendation;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ENatureApp {
    public static void main(String[] args) {

        ConcreteRecommendationCollection collection=new ConcreteRecommendationCollection();
        collection.addRecommendation(new Recommendation("item1", 0.5));
        collection.addRecommendation(new Recommendation("item2", 1.8));
        collection.addRecommendation(new Recommendation("item3", 0.9));
        collection.addRecommendation(new Recommendation("item4", 0.7));
        collection.addRecommendation(new Recommendation("item5", 0.6));

        RecommendationIterator iterator=collection.createIterator();

        while(iterator.hasNext()){
            Recommendation item=iterator.next();
            item.displayDetails();
        }

    }
}
