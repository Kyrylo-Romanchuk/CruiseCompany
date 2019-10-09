package ua.training.dao.mapper;

import ua.training.model.Cruise;
import ua.training.model.CruiseCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CruiseMapper implements ObjectMapper<Cruise> {
    @Override
    public Cruise extractFromResultSet(ResultSet rs) throws SQLException {
        Cruise cruise = new Cruise();
        cruise.setId(rs.getInt("cruise_id"));
        cruise.setName(rs.getString("cruise_name"));
         cruise.setShipById(rs.getInt("ship_id"));
        cruise.setCountryFromById(rs.getInt("cruise_city_from"));
        cruise.setCountryToById(rs.getInt("cruise_city_to"));
        cruise.setDeparture(cruise.convertToLocalDateTime(rs.getTimestamp("cruise_departure")));
        cruise.setArrival(cruise.convertToLocalDateTime(rs.getTimestamp("cruise_arrival")));
        cruise.setCategory(CruiseCategory.valueOf(rs.getString("cruise_category")));
        cruise.setCountPort(rs.getInt("cruise_count_port"));
        cruise.setPrice(rs.getLong("cruise_price"));
        return cruise;
    }

    @Override
    public Cruise makeUnique(Map<Integer, Cruise> cache, Cruise cruise) {
        cache.putIfAbsent(cruise.getId(),cruise);
        return cache.get(cruise.getId());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, Cruise cruise) throws SQLException {
            preparedStatement.setString(1,cruise.getName());
            preparedStatement.setInt(2,cruise.getShip().getShip_id());
            preparedStatement.setInt(3,cruise.getCountryFrom().getId());
            preparedStatement.setInt(4,cruise.getCountryTo().getId());
            preparedStatement.setTimestamp(5,cruise.convertToTimestap(cruise.getDeparture()));
            preparedStatement.setTimestamp(6,cruise.convertToTimestap(cruise.getArrival()));
            preparedStatement.setString(7,cruise.getCategory().name());
            preparedStatement.setInt(8,cruise.getCountPort());
            preparedStatement.setLong(9,cruise.getPrice());

    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Cruise cruise) throws SQLException {
        preparedStatement.setString(1,cruise.getName());
        preparedStatement.setInt(2,cruise.getShip().getShip_id());
        preparedStatement.setInt(3,cruise.getCountryFrom().getId());
        preparedStatement.setInt(4,cruise.getCountryTo().getId());
        preparedStatement.setTimestamp(5,cruise.convertToTimestap(cruise.getDeparture()));
        preparedStatement.setTimestamp(6,cruise.convertToTimestap(cruise.getArrival()));
        preparedStatement.setString(7,cruise.getCategory().name());
        preparedStatement.setInt(8,cruise.getCountPort());
        preparedStatement.setLong(9,cruise.getPrice());
        preparedStatement.setInt(10,cruise.getId());
    }
}
