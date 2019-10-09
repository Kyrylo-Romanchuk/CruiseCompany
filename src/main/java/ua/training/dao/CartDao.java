package ua.training.dao;

import ua.training.model.Cart;

import java.util.List;

public interface CartDao extends GenericDao<Cart> {
    List<Cart> findUserById(int id);
}
