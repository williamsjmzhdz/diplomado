package mx.unam.dgtic;

import mx.unam.dgtic.history.OnboardingMemento;
import mx.unam.dgtic.history.OnboardingStateSnapshot;
import mx.unam.dgtic.state.OnboardingState;

public class App {

    public static void main(String[] args) {
        UserRegistrationManager manager = new UserRegistrationManager();
        manager.setFirstName("Hector");
        manager.setLastName("Hernandez");
        manager.saveRegistration();
        manager.setDocument("123456789");
        manager.setStep("1");
        manager.setStep("2");
        manager.saveRegistration();
        manager.setStep("3");
        manager.setStep("4");

        manager.undoRegistration();



        System.out.println(manager.getState());
    }
}
