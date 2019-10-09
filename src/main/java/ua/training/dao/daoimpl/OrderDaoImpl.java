package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.OrderDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.OrderMapper;
import ua.training.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.OrderQuery.*;

public class OrderDaoImpl implements OrderDao {
    private final static Logger logger = Logger.getLogger(CartDaoImpl.class);
    private OrderMapper orderMapper;
    public OrderDaoImpl(){
        this.orderMapper= new OrderMapper();
    }

    @Override
    public boolean create(Order order) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Order");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER);
            orderMapper.setPreparedStatement(preparedStatement, order);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Order" + order.toString() + " was created!");
            } else {
                logger.info("Order " + order.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public Order findById(int id) {
        logger.info("Find by id");
        Order order=null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                order = orderMapper.extractFromResultSet(resultSet);
                logger.info("Founded : " + order.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        logger.info("find all");
        Map<Integer, Order> orders = new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Order order = orderMapper.extractFromResultSet(resultSet);
                order = orderMapper.makeUnique(orders, order);
                orders.put(order.getOrder_id(), order);
                logger.info("Added card to Map  :" + order.toString());
            }

            return new ArrayList<>(orders.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public void update(Order entity) {
       throw new  UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        logger.info("delete order by id :" + id);
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("Order " + id + " was deleted!");
            } else {
                logger.info("Order " + id + " was not deleted!");
            }

        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public List<Order> findUserById(int id) {
        logger.info("Find by Order id" +id);
        List<Order> cardList = new ArrayList<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDER_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do{
                    Order order =  new Order();
                    order = orderMapper.extractFromResultSet(resultSet);
                    logger.info("Founded : " + order.toString()+" and added to list");
                    cardList.add(order);
                }while (resultSet.next());
            }else{
                cardList=null;
                logger.info("Order list is empty");
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return cardList;
    }
}
