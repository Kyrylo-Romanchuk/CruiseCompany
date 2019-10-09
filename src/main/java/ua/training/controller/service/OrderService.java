package ua.training.controller.service;

import org.apache.log4j.Logger;
import ua.training.controller.service.Bean.CartItemBean;
import ua.training.controller.service.Bean.OrderItemBean;
import ua.training.dao.AbstractFactory;
import ua.training.dao.FactoryDao;
import ua.training.dao.daoimpl.*;
import ua.training.model.Cruise;
import ua.training.model.Excursion;
import ua.training.model.Order;
import ua.training.model.User;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final static Logger logger = Logger.getLogger(OrderService.class);
    private AbstractFactory factoryDao;
    private OrderDaoImpl orderDao;
    private CartDaoImpl cartDao;
    private UserDaoImpl userDao;
    private CruiseDaoImpl cruiseDao;
    private ExcursionDaoImpl excursionDao;
    private CountryDaoImpl countryDao;
    private ShipDaoImpl shipDao;

    public OrderService() {
        this.factoryDao = new FactoryDao();
        this.cartDao = factoryDao.createCartDao();
        this.userDao = factoryDao.createUserDao();
        this.cruiseDao = factoryDao.createCruiseDao();
        this.excursionDao = factoryDao.createExcursionDao();
        this.countryDao = factoryDao.createCountryDao();
        this.shipDao = factoryDao.createShipDao();
        this.orderDao = factoryDao.createOrderDao();
    }

    public String makeOrder(String userLogin, int cruiseId, int cartId, int excursionId) {
        List<CartItemBean> ordersList = findOrdersByUser(userLogin);
        if (ordersList != null) {
            for (CartItemBean item : ordersList) {
                if (item.getCruise().getId() == cruiseId) {
                    logger.info("Can't buy! This cruise already added in orders");
                    return "Can't buy! This cruise already added in orders";
                }
            }
        }

        Order order = new Order();
        order.setUser_id(userDao.findByLogin(userLogin).getId());
        order.setCruise_id(cruiseId);
        order.setPrice_total(cruiseDao.findById(cruiseId).getPrice() + excursionDao.findById(excursionId).getPrice());
        order.setExcursion_id(excursionId);
        Boolean result = orderDao.create(order);
        if (result) {
            logger.info("Order Succes");
            cartDao.delete(cartId);
            return "Order Succes";
        } else {
            logger.info("ERROR! Order not created!");
            return "ERROR! Order not created!";
        }

    }


    /**
     * Find all orders of user
     */
    public List<CartItemBean> findOrdersByUser(String userLogin) {
        List<Order> orderList = orderDao.findUserById(userDao.findByLogin(userLogin).getId());
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        if (orderList != null) {
            for (Order order : orderList) {
                Cruise cruise = cruiseDao.findById(order.getCruise_id());
                cruise.setCountryFrom(countryDao.findById(cruise.getCountryFromById()));
                cruise.setCountryTo(countryDao.findById(cruise.getCountryToById()));
                cruise.setShip(shipDao.findById(cruise.getShipById()));
                cartItemBeans.add(new CartItemBean(null, cruise, order.getExcursion()));
            }
        } else {
            cartItemBeans = null;
        }
        return cartItemBeans;
    }
    /**
     * Show all orders of user
     */
    public List<OrderItemBean> showListOrderByUser(User user){
        logger.info("show list order by Login" + user.getLogin());
        List<Order> orderList = orderDao.findUserById(user.getId());
        List<OrderItemBean> orderItemBeans = new ArrayList<>();
        if (orderList != null) {
            for (Order order : orderList) {
                Cruise cruise = cruiseDao.findById(order.getCruise_id());
                cruise.setCountryFrom(countryDao.findById(cruise.getCountryFromById()));
                cruise.setCountryTo(countryDao.findById(cruise.getCountryToById()));
                cruise.setShip(shipDao.findById(cruise.getShipById()));
                Excursion excursion = excursionDao.findById(order.getExcursion_id());
                orderItemBeans.add(new OrderItemBean(order,cruise,excursion));
            }
        } else {
            orderItemBeans = null;
        }

        return orderItemBeans;
    }

    /**
     * show all orders from DB
     * @return List<OrderItemBean>
     */
    public List<OrderItemBean> findAllOrders(){
        logger.info("Find all order from DB" );
        List<Order> orderList = orderDao.findAll();
        List<OrderItemBean> orderItemBeans = new ArrayList<>();
        if (orderList != null) {
            for (Order order : orderList) {
                User user = userDao.findById(order.getUser_id());
                Cruise cruise = cruiseDao.findById(order.getCruise_id());
                cruise.setCountryFrom(countryDao.findById(cruise.getCountryFromById()));
                cruise.setCountryTo(countryDao.findById(cruise.getCountryToById()));
                cruise.setShip(shipDao.findById(cruise.getShipById()));
                Excursion excursion = excursionDao.findById(order.getExcursion_id());
                orderItemBeans.add(new OrderItemBean(user,order,cruise,excursion));
            }
        } else {
            orderItemBeans = null;
        }

        return orderItemBeans;
    }

}
