package mx.unam.dgtic;

import mx.unam.dgtic.history.OnboardingHistory;
import mx.unam.dgtic.history.OnboardingMemento;
import mx.unam.dgtic.history.OnboardingStateSnapshot;
import mx.unam.dgtic.state.OnboardingState;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class UserRegistrationManager {
    private OnboardingState state;
    private OnboardingHistory history;

    public UserRegistrationManager() {
        state=new OnboardingState("","","","");
        history=new OnboardingHistory();
    }

    public void setFirstName(String firstName){
        state.setName(firstName);
    }
    public void setLastName(String lastName){
        state.setLastname(lastName);
    }
    public void setDocument(String document){
        state.setDocument(document);
    }
    public void setStep(String step){
        state.setStep(step);
    }

    public void saveRegistration(){
        OnboardingMemento snapshot=new OnboardingStateSnapshot(state);
        history.addSnapshot(snapshot);
    }

    public void undoRegistration(){
        if(history.hasSnapshot()){
            OnboardingMemento snapshot= history.undoSnapshot();
            state=snapshot.getState();
        }
    }

    public OnboardingState getState(){
        return history.getSnapshot().getState();
    }


}
