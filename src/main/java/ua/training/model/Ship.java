package ua.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ship implements Serializable {
    private final static long serialVersionUID = 1L;
    private int ship_id;
    private String name;
    private int capacity;

    private List<ShipImage> shipImageList = new ArrayList<>();


    public Ship() {
    }

    public Ship(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getShip_id() {
        return ship_id;
    }

    public void setShip_id(int ship_id) {
        this.ship_id = ship_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ShipImage> getShipImageList() {
        return shipImageList;
    }

    public void setShipImageList(List<ShipImage> shipImage) {
        this.shipImageList = shipImage;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ":, "+
                '}';
    }
}
