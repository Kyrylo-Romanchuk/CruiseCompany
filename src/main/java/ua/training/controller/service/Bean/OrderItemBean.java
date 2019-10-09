package ua.training.controller.service.Bean;

import ua.training.model.Cruise;
import ua.training.model.Excursion;
import ua.training.model.Order;
import ua.training.model.User;

public class OrderItemBean {
    private User user;
    private Order order;
    private Cruise cruise;
    private Excursion excursion;

    OrderItemBean() {
    }

    public OrderItemBean(Order order, Cruise cruise, Excursion excursion) {
        this.order = order;
        this.cruise = cruise;
        this.excursion = excursion;
    }

    public OrderItemBean(User user, Order order, Cruise cruise, Excursion excursion) {
        this.user = user;
        this.order = order;
        this.cruise = cruise;
        this.excursion = excursion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
