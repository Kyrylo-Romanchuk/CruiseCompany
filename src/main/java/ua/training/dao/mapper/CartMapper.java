package ua.training.dao.mapper;

import ua.training.model.Cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CartMapper implements ObjectMapper<Cart> {
    @Override
    public Cart extractFromResultSet(ResultSet rs) throws SQLException {
       Cart  cart = new Cart();
        cart.setCart_id(rs.getInt("cart_id"));
        cart.setUser_id(rs.getInt("user_id"));
        cart.setCruise_id(rs.getInt("cruise_id"));

        return cart;
    }

    @Override
    public Cart makeUnique(Map<Integer, Cart> cache, Cart cart) {
        cache.putIfAbsent(cart.getCart_id(),cart);
        return cache.get(cart.getCart_id());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, Cart cart) throws SQLException {
                      preparedStatement.setInt(1,cart.getUser_id());
                      preparedStatement.setInt(2,cart.getCruise_id());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Cart cart) throws SQLException {
        preparedStatement.setInt(1,cart.getUser_id());
        preparedStatement.setInt(2,cart.getCruise_id());
        preparedStatement.setInt(3,cart.getCart_id());
    }
}
