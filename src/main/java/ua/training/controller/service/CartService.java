package ua.training.controller.service;

import org.apache.log4j.Logger;
import ua.training.controller.service.Bean.CartItemBean;
import ua.training.dao.AbstractFactory;
import ua.training.dao.FactoryDao;
import ua.training.dao.daoimpl.*;
import ua.training.model.Cart;
import ua.training.model.Cruise;
import ua.training.model.Excursion;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final static Logger logger = Logger.getLogger(CartService.class);
    private AbstractFactory factoryDao;
    private CartDaoImpl cartDao;
    private UserDaoImpl userDao;
    private CruiseDaoImpl cruiseDao;
    private ExcursionDaoImpl excursionDao;
    private CountryDaoImpl countryDao;
    private ShipDaoImpl shipDao;

    public CartService(){
        this.factoryDao = new FactoryDao();
        this.cartDao=factoryDao.createCartDao();
        this.userDao=factoryDao.createUserDao();
        this.cruiseDao=factoryDao.createCruiseDao();
        this.excursionDao=factoryDao.createExcursionDao();
        this.countryDao=factoryDao.createCountryDao();
        this.shipDao=factoryDao.createShipDao();
    }

    /**
     * Add an order in user's cart
     * */
    public String addCartToUser(String userName, int cruiseId) {
        List<CartItemBean> cartsItemUser = findCartsByUser(userName);
        if (cartsItemUser != null) {
            for (CartItemBean bean : cartsItemUser) {
                if (bean.getCruise().getId() == cruiseId) {
                    logger.info( "This cruise is already added in bucket!!!");
                    return "This cruise is already added in bucket!!!";
                }
            }
        }
        Cart cart = new Cart();
        cart.setUser_id(userDao.findByLogin(userName).getId());
        logger.info("setUser to Cart : "+userDao.findByLogin(userName).getId());
        cart.setCruise_id(cruiseId);
        logger.info("setCruise to Cart : "+cruiseId);
        Boolean result = cartDao.create(cart);
        if(result) {
            return "Cart was created";
        } else {
            return "Cart was not created";
        }
    }
    /**
     * Find all orders in cart by user
     * */
    public List<CartItemBean> findCartsByUser(String userName) {
        List<Cart> carts = cartDao.findUserById(userDao.findByLogin(userName).getId());
        List<CartItemBean> cartItemBean = new ArrayList<>();
        if (carts != null) {
            for (Cart cart : carts) {
                Cruise cruise = cruiseDao.findById(cart.getCruise_id());
                cruise.setCountryFrom(countryDao.findById(cruise.getCountryFromById()));
                cruise.setCountryTo(countryDao.findById(cruise.getCountryToById()));
                cruise.setShip(shipDao.findById(cruise.getShipById()));
                List<Excursion> listExcursions = excursionDao.findByCountryId(cruise.getCountryToById());
                logger.info("Added to list Cruise : " +cruise.getName());
                cartItemBean.add(
                        new CartItemBean(cart,cruise,listExcursions));
            }
        } else {
            logger.info("Cart List is Empty");
            cartItemBean = null;
        }
        return cartItemBean;
    }

    /**
     * Delete all orders in user's cart.
     *
     * */
    public void deleteCartByUser(String userLogin) {
        List<Cart> carts = cartDao.findUserById(userDao.findByLogin(userLogin).getId());
        if (carts != null) {
            for (Cart cart : carts) {
                cartDao.delete(cart.getCart_id());
            }
            logger.info( "Cart of user " + userLogin + " was deleted!");
        } else {
            logger.info( "No carts to delete...");
        }
    }
}
