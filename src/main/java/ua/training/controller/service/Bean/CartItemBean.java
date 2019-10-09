package ua.training.controller.service.Bean;

import ua.training.model.Cart;
import ua.training.model.Cruise;
import ua.training.model.Excursion;

import java.util.List;

public class CartItemBean {


    private Cart cart;
    private Cruise cruise;
    private List<Excursion> excursion;
    CartItemBean(){}
    public CartItemBean(Cart cart, Cruise cruise, List<Excursion> excursion){
        this.cart=cart;
        this.cruise=cruise;
        this.excursion=excursion;
    }
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart card) {
        this.cart = cart;
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

}
