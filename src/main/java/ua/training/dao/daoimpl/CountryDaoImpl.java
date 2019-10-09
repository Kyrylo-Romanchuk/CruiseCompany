package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.CountryDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.CountryMapper;
import ua.training.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.CountryQuery.*;

public class CountryDaoImpl implements CountryDao {

    private final static Logger logger = Logger.getLogger(CountryDaoImpl.class);
    private CountryMapper countryMapper;

    public CountryDaoImpl() {
        this.countryMapper = new CountryMapper();
    }

    @Override
    public boolean create(Country country) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Country");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_COUNTRY);
            countryMapper.setPreparedStatement(preparedStatement, country);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Country " + country.toString() + " was created!");
            } else {
                logger.info("Country " + country.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public Country findById(int id) {
        logger.info("Find by id");
        Country country = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COUNTRY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                country = countryMapper.extractFromResultSet(resultSet);
                logger.info("Founded " + country.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return country;
    }

    @Override
    public List<Country> findAll() {
        logger.info("find all");
        Map<Integer, Country> countries = new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_COUNTRY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = countryMapper.extractFromResultSet(resultSet);
                country = countryMapper.makeUnique(countries, country);
                countries.put(country.getId(), country);
                logger.info("Added country to Map  :" + country.toString());
            }

            return new ArrayList<>(countries.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public void update(Country country) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COUNTRY);
            countryMapper.setPreparedStatementWithID(preparedStatement, country);
            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Country " + country.toString() + " was updated!");
            } else {
                logger.info("Country " + country.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void delete(int id) {
        logger.info("delete country by id :" + id);
        String cityName = findById(id).getCity();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COUNTRY_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("City " + cityName + " was deleted!");
            } else {
                logger.info("City " + cityName + " was not deleted!");
            }


        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
