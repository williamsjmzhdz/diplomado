package mx.unam.dgtic.history;

import java.util.Stack;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class OnboardingHistory {
    private final Stack<OnboardingMemento> snapshots;

    public OnboardingHistory() {
        this.snapshots = new Stack<>();
    }

    public void addSnapshot(OnboardingMemento snapshot){
        snapshots.add(snapshot);
    }

    public OnboardingMemento getSnapshot(){
        return snapshots.peek();
    }

    public OnboardingMemento undoSnapshot(){
        return snapshots.pop();
    }

    public boolean hasSnapshot(){
        return !snapshots.empty();
    }
}
