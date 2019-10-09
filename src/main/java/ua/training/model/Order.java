package ua.training.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final static long serialVersionUID = 1L;
    private int order_id;
    private int user_id;
    private int cruise_id;
    private int excursion_id;
    private User user;
    private Cruise cruise ;
    private List<Excursion> excursion = new ArrayList<>();
    private long price_total;

    public Order() {
    }

    public Order(User user, Cruise cruise, List<Excursion> excursion) {
        this.user = user;
        this.cruise = cruise;
        this.excursion = excursion;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public List<Excursion> getExcursion() {
        return excursion;
    }

    public void setExcursion(List<Excursion> excursion) {
        this.excursion = excursion;
    }

    public long getPrice_total() {
        return price_total;
    }

    public void setPrice_total(long price_total) {
        this.price_total = price_total;
    }

    public int getCruise_id() {
        return cruise_id;
    }

    public void setCruise_id(int cruise_id) {
        this.cruise_id = cruise_id;
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
        Order order = (Order) o;
        return order_id == order.order_id &&
                user_id == order.user_id &&
                cruise_id == order.cruise_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(order_id, user_id, cruise_id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "user_id=" + user_id +
                ", cruise_id=" + cruise_id +
                ", price_total=" + price_total +
                '}';
    }
}
