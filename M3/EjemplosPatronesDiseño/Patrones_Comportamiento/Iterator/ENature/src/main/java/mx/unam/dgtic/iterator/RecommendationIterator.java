package mx.unam.dgtic.iterator;

import mx.unam.dgtic.models.Recommendation;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface RecommendationIterator {
    boolean hasNext();
    Recommendation next();
}
