package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.ShipImageDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.ShipImageMapper;
import ua.training.model.ShipImage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.ShipImageQuery.*;

public class ShipImageDaoImpl implements ShipImageDao {

    private final static Logger logger = Logger.getLogger(ShipImageDaoImpl.class);
    private ShipImageMapper shipImageMapper;

    public ShipImageDaoImpl(){
        this.shipImageMapper=new ShipImageMapper();
    }
    @Override
    public boolean create(ShipImage shipImage) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Ship Image");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SHIP_IMAGE);
            shipImageMapper.setPreparedStatement(preparedStatement, shipImage);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Ship Image " + shipImage.toString() + " was created!");
            } else {
                logger.info("Ship Image " + shipImage.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public ShipImage findById(int id) {
        logger.info("Find by id");
        ShipImage shipImage = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SHIP_IMAGE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shipImage = shipImageMapper.extractFromResultSet(resultSet);
                logger.info("Founded : " + shipImage.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return shipImage;
    }

    @Override
    public List<ShipImage> findAll() {
        logger.info("find all");
        Map<Integer, ShipImage> shipImages = new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SHIP_IMAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShipImage shipImage = shipImageMapper.extractFromResultSet(resultSet);
                shipImage=shipImageMapper.makeUnique(shipImages,shipImage);
                shipImages.put(shipImage.getId(),shipImage);
                logger.info("Added ship image to Map  :" + shipImage.toString());
            }

            return new ArrayList<>(shipImages.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public void update(ShipImage shipImage) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SHIP_IMAGE);
            shipImageMapper.setPreparedStatementWithID(preparedStatement, shipImage);

            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Ship Image " + shipImage.toString() + " was updated!");
            } else {
                logger.info("Ship Image " + shipImage.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void delete(int id) {
        logger.info("delete ship image by id :" + id);
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SHIP_IMAGE_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("Ship Image ID :" + id + " was deleted!");
            } else {
                logger.info("Ship Image ID " + id + " was not deleted!");
            }


        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
