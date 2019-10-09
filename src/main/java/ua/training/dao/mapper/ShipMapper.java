package ua.training.dao.mapper;

import ua.training.model.Ship;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ShipMapper implements ObjectMapper<Ship> {
    @Override
    public Ship extractFromResultSet(ResultSet rs) throws SQLException {
        Ship ship = new Ship();
        ship.setShip_id(rs.getInt("ship_id"));
        ship.setName(rs.getString("ship_name"));
        ship.setCapacity(rs.getInt("ship_capacity"));
        return ship;
    }

    @Override
    public Ship makeUnique(Map<Integer, Ship> cache, Ship ship) {
        cache.putIfAbsent(ship.getShip_id(), ship);
        return cache.get(ship.getShip_id());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement,
                                     Ship ship) throws SQLException {
        preparedStatement.setString(1, ship.getName());
        preparedStatement.setInt(2, ship.getCapacity());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, Ship ship) throws SQLException {
        preparedStatement.setString(1, ship.getName());
        preparedStatement.setInt(2, ship.getCapacity());
        preparedStatement.setInt(3,ship.getShip_id());
    }
}
