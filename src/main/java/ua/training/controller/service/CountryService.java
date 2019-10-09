package ua.training.controller.service;

import org.apache.log4j.Logger;
import ua.training.dao.AbstractFactory;
import ua.training.dao.CountryDao;
import ua.training.dao.FactoryDao;
import ua.training.model.Country;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CountryService {
    private final static Logger logger = Logger.getLogger(CountryService.class);
    private AbstractFactory factoryDao;
    private CountryDao countryDao;
    public CountryService(){
        this.factoryDao=new FactoryDao();
        countryDao=factoryDao.createCountryDao();
    }

    /**
     * add new Country in DB
     * @param request
     * @return
     */
    public boolean addNewCountry(HttpServletRequest request){
        logger.info("registration ");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        Country country = new Country(name,city);
        boolean result = countryDao.create(country);
        if (result) {
            logger.info("Created country " + country.toString());
        } else {
            logger.error("Error");
        }
        return result;

    }

    /**
     * show all countries
     * @return list of countries
     */
    public List showListContry(){
        logger.info("show list country");
        List<Country> list = countryDao.findAll();
         return list;
    }

    /**
     * find by id Country
     * @param id
     * @return
     */
    public Country findById(int id){
        Country country = countryDao.findById(id);
        return country;
    }

    /**
     * Edit country by id
     * @param request
     */
    public void updateCountry(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        Country country = new Country(id,name,city);
        countryDao.update(country);
        logger.info("Updated : "+country.toString());
    }

    /**
     * delete Country by id
     * @param request
     */
    public void deleteById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        countryDao.delete(id);
        logger.info("Deleted country : " + id);
    }


}
