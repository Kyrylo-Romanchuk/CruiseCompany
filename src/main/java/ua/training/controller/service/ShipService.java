package ua.training.controller.service;

import org.apache.log4j.Logger;
import ua.training.dao.AbstractFactory;
import ua.training.dao.FactoryDao;
import ua.training.dao.ShipDao;
import ua.training.model.Ship;

import java.util.List;

public class ShipService {

    private final static Logger logger = Logger.getLogger(ShipService.class);
    private AbstractFactory factoryDao;
    private ShipDao shipDao;

    public ShipService() {
        this.factoryDao = new FactoryDao();
        this.shipDao = factoryDao.createShipDao();
    }

    /**
     * show all ships fron DB
     * @return list of ships
     */
    public List<Ship> showListShips() {
        logger.info("show list ship");
        List<Ship> list = shipDao.findAll();
        return list;
    }


}
