package ua.training.model;

import java.io.Serializable;

public class ShipImage implements Serializable {

    private final static long serialVersionUID = 1L;

    private int id;
    private String uri;
    private Ship ship;


    public ShipImage() {
    }

    public ShipImage(int id, String uri) {
        this.id = id;
        this.uri = uri;
    }

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "ShipImage{" +
                "uri='" + uri + '\'' +
                ", ship=" + ship.getName() +
                '}';
    }
}
