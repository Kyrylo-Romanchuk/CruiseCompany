package ua.training.dao.mapper;

import ua.training.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderMapper implements ObjectMapper<Order> {
    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrder_id(rs.getInt("order_id"));
        order.setUser_id(rs.getInt("user_id"));
        order.setCruise_id(rs.getInt("cruise_id"));
        order.setExcursion_id(rs.getInt("excursion_id"));
        order.setPrice_total(rs.getLong("price_total"));
        return order;
    }

    @Override
    public Order makeUnique(Map<Integer, Order> cache, Order order) {
        cache.putIfAbsent(order.getOrder_id(),order);
        return cache.get(order.getOrder_id());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, Order order) throws SQLException {
        preparedStatement.setInt(1,order.getUser_id());
        preparedStatement.setInt(2,order.getCruise_id());
        preparedStatement.setInt(3,order.getExcursion_id());
        preparedStatement.setLong(4,order.getPrice_total());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Order order) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
