package ua.training.dao;

import ua.training.model.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> findUserById(int id);
}
