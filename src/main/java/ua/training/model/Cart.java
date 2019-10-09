package ua.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private final static long serialVersionUID = 1L;
    private int cart_id;
    private int user_id;
    private int cruise_id;
    private int excursion_id;
    private User user;
    private Cruise cruise ;
    private List<Excursion> excursion = new ArrayList<>();

    public Cart() {
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }
    public int getCruise_id() {
        return cruise_id;
    }

    public void setCruise_id(int cruise_id) {
        this.cruise_id = cruise_id;
    }

    public List<Excursion> getExcursion() {
        return excursion;
    }

    public void setExcursion(List<Excursion> excursion) {
        this.excursion = excursion;
    }

    public int getExcursion_id() {
        return excursion_id;
    }

    public void setExcursion_id(int excursion_id) {
        this.excursion_id = excursion_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cart_id == cart.cart_id &&
                user_id == cart.user_id &&
                cruise_id == cart.cruise_id;
    }

    @Override
    public int hashCode() {
        int result = cart_id;
        result = 31 * result + user_id;
        result = 31 * result +cruise_id;
        return result;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "user_id=" + user_id +
                ", cruise_id=" + cruise_id +
                '}';
    }
}
