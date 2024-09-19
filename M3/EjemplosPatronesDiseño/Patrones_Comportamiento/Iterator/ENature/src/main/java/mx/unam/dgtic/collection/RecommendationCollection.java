package mx.unam.dgtic.collection;

import mx.unam.dgtic.iterator.RecommendationIterator;

public interface RecommendationCollection {
    RecommendationIterator createIterator();
}
