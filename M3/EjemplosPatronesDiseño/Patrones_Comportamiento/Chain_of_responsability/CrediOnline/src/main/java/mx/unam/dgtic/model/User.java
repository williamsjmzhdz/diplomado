package mx.unam.dgtic.model;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class User {
    private String email;
    private String password;
    private String name;
    private double score;
    private double riskThreshold;
    private double creditLimit;

    public User() {
    }

    public User(String email, String password, String name, double score, double riskThreshold, double creditLimit) {
        this.email = email;
        this.password= password;
        this.name = name;
        this.score = score;
        this.riskThreshold = riskThreshold;
        this.creditLimit = creditLimit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getRiskThreshold() {
        return riskThreshold;
    }

    public void setRiskThreshold(double riskThreshold) {
        this.riskThreshold = riskThreshold;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
