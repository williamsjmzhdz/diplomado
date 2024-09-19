package mx.unam.dgtic.state;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class OnboardingState {
    private String name;
    private String lastname;
    private String document;
    private String step;

    public OnboardingState(String name, String lastname, String document, String step) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "OnboardingState{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", document='" + document + '\'' +
                ", step='" + step + '\'' +
                '}';
    }

    

}
