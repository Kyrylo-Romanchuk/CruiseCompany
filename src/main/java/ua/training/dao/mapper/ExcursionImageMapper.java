package ua.training.dao.mapper;

import ua.training.model.ExcursionImage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ExcursionImageMapper implements ObjectMapper<ExcursionImage> {
    @Override
    public ExcursionImage extractFromResultSet(ResultSet rs) throws SQLException {
        ExcursionImage excursionImage = new ExcursionImage();
        excursionImage.setId(rs.getInt("excursionimage_id"));
        excursionImage.setUri(rs.getString("excursionimage_uri"));
        return excursionImage;
    }

    @Override
    public ExcursionImage makeUnique(Map<Integer, ExcursionImage> cache, ExcursionImage excursionImage) {
        cache.putIfAbsent(excursionImage.getId(), excursionImage);
        return cache.get(excursionImage.getId());
    }

    @Override
    public void setPreparedStatement(PreparedStatement preparedStatement, ExcursionImage excursionImage) throws SQLException {
             preparedStatement.setString(1,excursionImage.getUri());
    }

    @Override
    public void setPreparedStatementWithID(PreparedStatement preparedStatement, ExcursionImage excursionImage) throws SQLException {
        preparedStatement.setString(1,excursionImage.getUri());
        preparedStatement.setInt(2,excursionImage.getId());
    }
}
