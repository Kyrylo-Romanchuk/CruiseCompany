package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.controller.service.CruiseService;
import ua.training.dao.CruiseDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.CountryMapper;
import ua.training.dao.mapper.CruiseMapper;
import ua.training.dao.mapper.ShipImageMapper;
import ua.training.dao.mapper.ShipMapper;
import ua.training.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.dao.query.CruiseQuery.*;

public class CruiseDaoImpl implements CruiseDao {
    private final static Logger logger = Logger.getLogger(CruiseDaoImpl.class);
    private CruiseMapper cruiseMapper;
    private CountryMapper countryMapper;
    private ShipMapper shipMapper;
    private ShipImageMapper shipImageMapper;


    public CruiseDaoImpl() {
        this.cruiseMapper = new CruiseMapper();
        this.countryMapper = new CountryMapper();
        this.shipMapper = new ShipMapper();
        this.shipImageMapper = new ShipImageMapper();
    }

    @Override
    public boolean create(Cruise cruise) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Cruise");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CRUISE);
            cruiseMapper.setPreparedStatement(preparedStatement, cruise);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Cruise " + cruise.toString() + " was created!");
            } else {
                logger.info("Cruise " + cruise.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public Cruise findById(int id) {
        logger.info("Find by id");
        Cruise cruise = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CRUISE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cruise = cruiseMapper.extractFromResultSet(resultSet);
                logger.info("Founded : " + cruise.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return cruise;
    }

    @Override
    public List<Cruise> findAll() {
        List<Cruise> list = new ArrayList<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    Cruise cruise = new Cruise();
                    Ship ship = new Ship();
                    ShipImage shipImage = new ShipImage();
                    Country countryFrom = new Country();
                    Country countryTo = new Country();
                    cruise.setId(resultSet.getInt("cruise_id"));
                    cruise.setName(resultSet.getString("cruise_name"));
                    ship.setShip_id(resultSet.getInt("ship_id"));
                    ship.setName(resultSet.getString("ship_name"));
                    ship.setCapacity(resultSet.getInt("ship_capacity"));
                    shipImage.setId(resultSet.getInt("shipimage_id"));
                    shipImage.setUri(resultSet.getString("shipimage_uri"));
                    countryFrom.setId(resultSet.getInt("country_from_id"));
                    countryFrom.setName(resultSet.getString("country_from_name"));
                    countryFrom.setCity(resultSet.getString("country_from_city"));
                    countryTo.setId(resultSet.getInt("country_to_id"));
                    countryTo.setName(resultSet.getString("country_to_name"));
                    countryTo.setCity(resultSet.getString("country_to_city"));
                    cruise.setDeparture(cruise.convertToLocalDateTime(resultSet.getTimestamp("cruise_departure")));
                    cruise.setArrival(cruise.convertToLocalDateTime(resultSet.getTimestamp("cruise_arrival")));
                    cruise.setCategory(CruiseCategory.valueOf(resultSet.getString("cruise_category")));
                    cruise.setCountPort(resultSet.getInt("cruise_count_port"));
                    cruise.setPrice(resultSet.getLong("cruise_price"));
                    ship.getShipImageList().add(shipImage);
                    shipImage.setShip(ship);
                    cruise.setShip(ship);
                    cruise.setCountryFrom(countryFrom);
                    cruise.setCountryTo(countryTo);
                    logger.info("Added cruise to List  :" +cruise.toString() );

                    list.add(cruise);
                } while (resultSet.next());
            } else {
                logger.error("Result Set is empty!");
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        return list;
    }

    @Override
    public void update(Cruise cruise) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CRUISE);
            cruiseMapper.setPreparedStatementWithID(preparedStatement, cruise);
            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Cruise " + cruise.toString() + " was updated!");
            } else {
                logger.info("Cruise " + cruise.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void delete(int id) {
        logger.info("delete cruise by id :" + id);
        String cruiseName = findById(id).getName();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CRUISE_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Cruise " + cruiseName + " was deleted!");
            } else {
                logger.info("Cruise " + cruiseName + " was not deleted!");
            }


        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public List<Cruise> findAllWithLimit(int offset) {
        logger.info("Find all cruise with limit " + CruiseService.LIMIT_CRUISE + " and offset " + offset);
        List<Cruise> list = new ArrayList<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_WITH_LIMIT);
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, CruiseService.LIMIT_CRUISE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    Cruise cruise = new Cruise();
                    Ship ship = new Ship();
                    ShipImage shipImage = new ShipImage();
                    Country countryFrom = new Country();
                    Country countryTo = new Country();
                    cruise.setId(resultSet.getInt("cruise_id"));
                    cruise.setName(resultSet.getString("cruise_name"));
                    ship.setShip_id(resultSet.getInt("ship_id"));
                    ship.setName(resultSet.getString("ship_name"));
                    ship.setCapacity(resultSet.getInt("ship_capacity"));
                    shipImage.setId(resultSet.getInt("shipimage_id"));
                    shipImage.setUri(resultSet.getString("shipimage_uri"));
                    countryFrom.setId(resultSet.getInt("country_from_id"));
                    countryFrom.setName(resultSet.getString("country_from_name"));
                    countryFrom.setCity(resultSet.getString("country_from_city"));
                    countryTo.setId(resultSet.getInt("country_to_id"));
                    countryTo.setName(resultSet.getString("country_to_name"));
                    countryTo.setCity(resultSet.getString("country_to_city"));
                    cruise.setDeparture(cruise.convertToLocalDateTime(resultSet.getTimestamp("cruise_departure")));
                    cruise.setArrival(cruise.convertToLocalDateTime(resultSet.getTimestamp("cruise_arrival")));
                    cruise.setCategory(CruiseCategory.valueOf(resultSet.getString("cruise_category")));
                    cruise.setCountPort(resultSet.getInt("cruise_count_port"));
                    cruise.setPrice(resultSet.getLong("cruise_price"));
                    ship.getShipImageList().add(shipImage);
                    shipImage.setShip(ship);
                    cruise.setShip(ship);
                    cruise.setCountryFrom(countryFrom);
                    cruise.setCountryTo(countryTo);
                    logger.info("Added cruise to List : "+cruise.toString());
                    list.add(cruise);
                } while (resultSet.next());
            } else {
                logger.error("Result Set is empty!");
            }
        } catch (SQLException e) {
             logger.error(e.toString());
        }

        return list;
    }

    @Override
    public int countCruise() {

        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CRUISE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;

        } catch (SQLException e) {
          logger.error(e.toString());
            throw new RuntimeException(e);
        }
    }
}
