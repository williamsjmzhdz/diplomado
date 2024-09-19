package mx.unam.dgtic.collection;

import java.util.ArrayList;
import java.util.List;

import mx.unam.dgtic.iterator.RecommendationIterator;
import mx.unam.dgtic.iterator.RecommendationIteratorImpl;
import mx.unam.dgtic.models.Recommendation;

public class ConcreteRecommendationCollection implements RecommendationCollection{

    private List<Recommendation> recommendations=new ArrayList<>();

    public void addRecommendation(Recommendation recommendation) {
        if(recommendation.getScore()>=0.0 && recommendation.getScore()<=1.0){
            recommendations.add(recommendation);
        }
    }

    @Override
    public RecommendationIterator createIterator() {
        return new RecommendationIteratorImpl(recommendations);
    }
    
}
