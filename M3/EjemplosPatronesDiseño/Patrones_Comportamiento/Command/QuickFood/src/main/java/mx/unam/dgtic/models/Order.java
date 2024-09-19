package mx.unam.dgtic.models;

import java.util.List;
import java.util.UUID;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Order {
    private String uuid;
    private String name;
    private String restaurant;
    private List<String> requirements;
    private String user;
    private double cost;
    private String status;

    public Order() {
    }

    public Order(String name, String restaurant, List<String> requirements, String user, double cost, String status) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.restaurant = restaurant;
        this.requirements = requirements;
        this.user = user;
        this.cost = cost;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", requirements=" + requirements +
                ", user='" + user + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                '}';
    }
}
