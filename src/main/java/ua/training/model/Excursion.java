package ua.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Excursion implements Serializable {
    private final static long serialVersionUID = 1L;
    private int id;
    private int country;
    private String name;
    private String description;
    private long price;
    private List<ExcursionImage> excursionImageList = new ArrayList<>();

    public Excursion() {
    }

    public Excursion(int country, String name, String description, long price) {
        this.country = country;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<ExcursionImage> getExcursionImageList() {
        return excursionImageList;
    }

    public void setExcursionImageList(List<ExcursionImage> excursionImageList) {
        this.excursionImageList = excursionImageList;
    }

    @Override
    public int hashCode() {
        return 31 * id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Excursion e = (Excursion) obj;
            return id == e.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "country=" + country +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
