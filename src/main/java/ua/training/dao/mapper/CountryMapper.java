package ua.training.dao.mapper;

import ua.training.model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CountryMapper implements ObjectMapper<Country> {
    @Override
    public Country extractFromResultSet(ResultSet rs) throws SQLException {
        Country country = new Country();
        country.setId(rs.getInt("country_id"));
        country.setName(rs.getString("country_name"));
        country.setCity(rs.getString("country_city"));
        return country;
    }

    @Override
    public Country makeUnique(Map<Integer,Country> cache, Country country) {
        cache.putIfAbsent(country.getId(),country);
        return cache.get(country.getId());
    }


    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, Country country) throws SQLException {
        preparedStatement.setString(1,country.getName());
        preparedStatement.setString(2,country.getCity());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Country country) throws SQLException {
        preparedStatement.setString(1,country.getName());
        preparedStatement.setString(2,country.getCity());
        preparedStatement.setInt(3,country.getId());
    }
}
