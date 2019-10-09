package ua.training.dao.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;

    T makeUnique(Map<Integer, T> cache,
                 T object);
    void setPreparedStatement(PreparedStatement preparedStatement, T object) throws SQLException;
    void setPreparedStatementWithID(PreparedStatement preparedStatement, T object) throws SQLException;
}
