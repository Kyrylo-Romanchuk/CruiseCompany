package ua.training.controller.service;

import org.apache.log4j.Logger;
import ua.training.dao.AbstractFactory;
import ua.training.dao.CruiseDao;
import ua.training.dao.FactoryDao;
import ua.training.model.Cruise;

import java.util.List;

public class CruiseService {
    private final static Logger logger = Logger.getLogger(CruiseService.class);
    public static final int LIMIT_CRUISE = 2;
    private CruiseDao cruiseDao;
    private AbstractFactory factoryDao;

    public CruiseService() {
        this.factoryDao = new FactoryDao();
        this.cruiseDao = factoryDao.createCruiseDao();
    }

    /**
     * show all cruise from DB
     * @return list of cruises
     */
    public List showListCruise() {
        logger.info("show list cruise");
        List<Cruise> list = cruiseDao.findAll();
        return list;
    }
    /**
     * show cruise wit limit for pagination from DB
     * @return list cruises
     */
    public List showListCruiseWithLimit(int page) {
        logger.info("show list cruise");
        List<Cruise> list = cruiseDao.findAllWithLimit(offset(page));
        return list;
    }

    private int offset(int pageNumber) {
        return (pageNumber * LIMIT_CRUISE) - LIMIT_CRUISE;
    }

    /**
     * select count(*) from cruise.cruise
     * @return
     */
    public int quantityOfPages() {
        return cruiseDao.countCruise();
    }
}
