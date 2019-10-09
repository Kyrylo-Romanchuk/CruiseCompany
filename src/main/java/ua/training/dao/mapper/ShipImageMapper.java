package ua.training.dao.mapper;

import ua.training.model.ShipImage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ShipImageMapper implements ObjectMapper<ShipImage> {
    @Override
    public ShipImage extractFromResultSet(ResultSet rs) throws SQLException {
        ShipImage shipImage = new ShipImage();
        shipImage.setId(rs.getInt("shipimage_id"));
        shipImage.setUri(rs.getString("shipimage_uri"));
        return shipImage;
    }

    @Override
    public ShipImage makeUnique(Map<Integer, ShipImage> cache, ShipImage shipImage) {
        cache.putIfAbsent(shipImage.getId(), shipImage);
        return cache.get(shipImage.getId());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, ShipImage shipImage) throws SQLException {
     preparedStatement.setString(1,shipImage.getUri());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, ShipImage shipImage) throws SQLException {
        preparedStatement.setString(1,shipImage.getUri());
        preparedStatement.setInt(2,shipImage.getId());
    }
}
