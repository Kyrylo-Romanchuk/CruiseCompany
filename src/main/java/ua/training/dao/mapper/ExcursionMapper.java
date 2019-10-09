package ua.training.dao.mapper;

import ua.training.model.Excursion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ExcursionMapper implements ObjectMapper<Excursion> {
    @Override
    public Excursion extractFromResultSet(ResultSet rs) throws SQLException {
        Excursion excursion = new Excursion();
        excursion.setId(rs.getInt("excursion_id"));
        excursion.setCountry(rs.getInt("country_id"));
        excursion.setName(rs.getString("excursion_name"));
        excursion.setDescription(rs.getString("excursion_description"));
        excursion.setPrice(rs.getLong("excursion_price"));
        return excursion;
    }

    @Override
    public Excursion makeUnique(Map<Integer, Excursion> cache, Excursion excursion) {
        cache.putIfAbsent(excursion.getId(), excursion);
        return cache.get(excursion.getId());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, Excursion excursion) throws SQLException {
        preparedStatement.setInt(1, excursion.getCountry());
        preparedStatement.setString(2, excursion.getName());
        preparedStatement.setString(3, excursion.getDescription());
        preparedStatement.setLong(4, excursion.getPrice());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Excursion excursion) throws SQLException {
        preparedStatement.setInt(1, excursion.getCountry());
        preparedStatement.setString(2, excursion.getName());
        preparedStatement.setString(3, excursion.getDescription());
        preparedStatement.setLong(4, excursion.getPrice());
        preparedStatement.setInt(5,excursion.getId());
    }
}
