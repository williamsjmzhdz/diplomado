package mx.unam.dgtic.model;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Request {
    private User user;
    private double riskScore;
    private double amount;

    public Request() {
    }

    public Request(User user, double riskScore, double amount) {
        this.user = user;
        this.riskScore = riskScore;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
