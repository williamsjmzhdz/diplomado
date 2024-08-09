package edu.unam.ejercicio.model;

import java.util.Objects;

public class TableTest {
    private Integer id;
    private String name;
    private String lastName;

    public TableTest(Integer id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public TableTest() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableTest tableTest)) return false;
        return Objects.equals(getId(), tableTest.getId()) && Objects.equals(getName(), tableTest.getName()) && Objects.equals(getLastName(), tableTest.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName());
    }

    @Override
    public String toString() {
        return "TableTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
