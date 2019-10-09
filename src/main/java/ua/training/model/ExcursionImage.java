package ua.training.model;

import java.io.Serializable;

public class ExcursionImage implements Serializable {
    private final static long serialVersionUID = 1L;

    private int id;
    private String uri;
    private Excursion excursion;

    public ExcursionImage(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    @Override
    public String toString() {
        return "ExcursionImage{" +
                "uri='" + uri + '\'' +
                ", excursion=" + excursion.getName() +
                '}';
    }
}
