package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.CartDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.CartMapper;
import ua.training.model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.CartQuery.*;

public class CartDaoImpl implements CartDao {

    private final static Logger logger = Logger.getLogger(CartDaoImpl.class);
    private CartMapper cartMapper;

    public CartDaoImpl() {
        this.cartMapper = new CartMapper();
    }

    @Override
    public boolean create(Cart cart) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Cart");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CART);
            cartMapper.setPreparedStatement(preparedStatement, cart);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Cart " + cart.toString() + " was created!");
            } else {
                logger.info("Cart " + cart.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public Cart findById(int id) {
        logger.info("Find by id");
        Cart cart=null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cart = cartMapper.extractFromResultSet(resultSet);
                logger.info("Founded : " + cart.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return cart;
    }

    @Override
    public List<Cart> findAll() {
        logger.info("find all");
        Map<Integer, Cart> carts = new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CART);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Cart cart = cartMapper.extractFromResultSet(resultSet);
                cart = cartMapper.makeUnique(carts, cart);
                carts.put(cart.getCart_id(), cart);
                logger.info("Added cart to Map  :" + cart.toString());
            }

            return new ArrayList<>(carts.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public void update(Cart cart) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART);
            cartMapper.setPreparedStatementWithID(preparedStatement, cart);

            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Cart " + cart.toString() + " was updated!");
            } else {
                logger.info("Cart " + cart.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void delete(int id) {
        logger.info("delete cart by id :" + id);
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("Cart " + id + " was deleted!");
            } else {
                logger.info("Cart " + id + " was not deleted!");
            }

        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public List<Cart> findUserById(int id) {
        logger.info("Find by card id" +id);
        List<Cart> cartList = new ArrayList<>();
        Cart cart =  null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do{
                    cart = cartMapper.extractFromResultSet(resultSet);
                    logger.info("Founded : " + cart.toString()+" and added to list");
                    cartList.add(cart);
                }while (resultSet.next());
            }else{
                cartList=null;
                logger.info("Cart list is empty");
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return cartList;
    }
}
