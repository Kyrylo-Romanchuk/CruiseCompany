package ua.training.dao.mapper;

import ua.training.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setLogin(rs.getString("user_login"));
        user.setPassword(rs.getString("user_password"));
        user.setFirstName(rs.getString("user_first_name"));
        user.setLastName(rs.getString("user_last_name"));
        user.setEmail(rs.getString("user_email"));
        user.setRole(User.Role.valueOf(rs.getString("user_role")));
        user.setCreated(user.convertToLocalDateTime(rs.getTimestamp("user_created")));
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getRole().name());
        preparedStatement.setTimestamp(7, user.convertToTimestap(user.getCreated()));
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getRole().name());
        preparedStatement.setTimestamp(7, user.convertToTimestap(user.getCreated()));
        preparedStatement.setInt(8,user.getId());
    }
}
