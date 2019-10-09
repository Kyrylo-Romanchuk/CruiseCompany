package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.ExcursionImageDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.ExcursionImageMapper;
import ua.training.model.ExcursionImage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.ExcursionImageQuery.*;

public class ExcursionImageDaoImpl implements ExcursionImageDao {
    private final static Logger logger = Logger.getLogger(ExcursionDaoImpl.class);
    private ExcursionImageMapper excursionImageMapper;

    public ExcursionImageDaoImpl(){
        this.excursionImageMapper=new ExcursionImageMapper();
    }

    @Override
    public boolean create(ExcursionImage excursionImage) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new Excursion Image");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EXCURSIONIMAGE);
            excursionImageMapper.setPreparedStatement(preparedStatement, excursionImage);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Excursion Image " + excursionImage.toString() + " was created!");
            } else {
                logger.info("Excursion Image " + excursionImage.toString() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public ExcursionImage findById(int id) {
        logger.info("Find by id");
      ExcursionImage excursionImage = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EXCURSION_IMAGE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                excursionImage = excursionImageMapper.extractFromResultSet(resultSet);
                logger.info("Founded : " + excursionImage.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return excursionImage;
    }

    @Override
    public List<ExcursionImage> findAll() {
        logger.info("find all");
        Map<Integer, ExcursionImage> excursionImages= new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_EXCURSIONIMAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ExcursionImage excursionImage = excursionImageMapper.extractFromResultSet(resultSet);
                excursionImage=excursionImageMapper.makeUnique(excursionImages,excursionImage);
                excursionImages.put(excursionImage.getId(),excursionImage);
                logger.info("Added excursion image to Map  :" + excursionImage.toString());
            }

            return new ArrayList<>(excursionImages.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public void update(ExcursionImage excursionImage) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EXCURSIONIMAGE);
            excursionImageMapper.setPreparedStatementWithID(preparedStatement, excursionImage);

            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("Excursion Image " + excursionImage.toString() + " was updated!");
            } else {
                logger.info("Excursion Image " + excursionImage.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void delete(int id) {
        logger.info("delete excursion image by id :" + id);
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXCURSION_IMAGE_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("Excursion Image ID :" + id + " was deleted!");
            } else {
                logger.info("Excursion Image ID " + id + " was not deleted!");
            }


        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
