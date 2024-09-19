package mx.unam.dgtic.iterator;

import mx.unam.dgtic.models.Recommendation;

import java.util.List;
import java.util.NoSuchElementException;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class RecommendationIteratorImpl implements RecommendationIterator{
    private List<Recommendation> recommendations;
    private int position;

    public RecommendationIteratorImpl(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
        position=0;
    }

    @Override
    public boolean hasNext() {
        return position<recommendations.size();
    }

    @Override
    public Recommendation next() {
        if(hasNext()){
            return recommendations.get(position++);
        }
        return null;
    }
}
