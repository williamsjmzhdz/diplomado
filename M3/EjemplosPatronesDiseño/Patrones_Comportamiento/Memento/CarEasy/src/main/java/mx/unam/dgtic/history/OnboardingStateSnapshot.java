package mx.unam.dgtic.history;

import mx.unam.dgtic.state.OnboardingState;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class OnboardingStateSnapshot implements OnboardingMemento{

    private OnboardingState state;

    public OnboardingStateSnapshot(OnboardingState state) {
        this.state = new OnboardingState(state.getName(), state.getLastname(), state.getDocument(), state.getStep());
    }

    @Override
    public OnboardingState getState() {
        return state;
    }
}
