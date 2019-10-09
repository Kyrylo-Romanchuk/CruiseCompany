package ua.training.dao.daoimpl;

import org.apache.log4j.Logger;
import ua.training.dao.UserDao;
import ua.training.dao.connection.DataSourceConnection;
import ua.training.dao.mapper.UserMapper;
import ua.training.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.query.UserQuery.*;


public class UserDaoImpl implements UserDao {

    private final static Logger logger = Logger.getLogger(UserDaoImpl.class);
    private UserMapper userMapper;

    public UserDaoImpl() {
     this.userMapper= new UserMapper();
    }

    @Override
    public boolean create(User user) {
        boolean result = false;
        try (Connection connection = DataSourceConnection.getConnection()) {
            logger.info("Create new User");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            userMapper.setPreparedStatement(preparedStatement, user);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("User " + user.getLogin() + " was created!");
            } else {
                logger.info("User " + user.getLogin() + " does not create!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return result;
    }

    @Override
    public User findById(int id) {
        logger.info("Find by id");
        User user = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = userMapper.extractFromResultSet(resultSet);
            logger.info("founded " + user.getLogin());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        logger.info("find all");
        Map<Integer, User> users = new HashMap<>();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USER);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                User user = userMapper.extractFromResultSet(resultSet);
                user = userMapper.makeUnique(users, user);
                users.put(user.getId(), user);
                logger.info("Added user to Map  :" + user.toString());
            }

            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }

    }


    @Override
    public void update(User user) {
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            userMapper.setPreparedStatementWithID(preparedStatement, user);

            boolean result = preparedStatement.executeUpdate() > 0;
            if (result) {
                connection.commit();
                logger.info("User " + user.toString() + " was updated!");
            } else {
                logger.info("User " + user.toString() + " does not uptade!");

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

    }

    @Override
    public void delete(int id) {
        logger.info("delete user by id :" + id);
        String userLogin = findById(id).getLogin();
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            boolean result = preparedStatement.executeUpdate()>0;
            if (result) {
                connection.commit();
                logger.info("User " + userLogin + " was deleted!");
            } else {
                logger.info("User " + userLogin + " was not deleted!");
            }


        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public User findByEmail(String email) {
        logger.info("Find by email : " + email);
        User user = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = userMapper.extractFromResultSet(resultSet);
                logger.info("Founded :  " + user.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        logger.info("Find by login : " + login);
        User user = null;
        try (Connection connection = DataSourceConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USER);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = userMapper.extractFromResultSet(resultSet);
                logger.info("Founded :  " + user.toString());
            }
        } catch (SQLException e) {
            logger.error(e.toString());
            return null;
        }
        return user;
    }


}
