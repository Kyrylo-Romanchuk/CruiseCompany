package ua.training.model;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable {
    private final static long serialVersionUID = 1L;
    private int id;
    private String name;
    private String city;
    public Country(){}
    public Country(int id){
        this.id=id;
    }
    public Country(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public Country(int id, String name, String city) {
        this.id=id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(name, country.name) &&
                Objects.equals(city, country.city);
    }

    @Override
    public int hashCode() {
        return 31 * id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
