package ua.training.dao.query;

public interface CountryQuery {
    String FIND_ALL_COUNTRY = "SELECT * FROM CRUISE.COUNTRY";
    String FIND_COUNTRY_BY_ID = "SELECT * FROM CRUISE.COUNTRY WHERE COUNTRY_ID = ?";
    String DELETE_COUNTRY_BY_ID = "DELETE FROM CRUISE.COUNTRY WHERE COUNTRY_ID = ?";
    String CREATE_COUNTRY = "INSERT INTO CRUISE.COUNTRY (country_name, country_city) VALUES(?, ?)";
    String UPDATE_COUNTRY=  "UPDATE CRUISE.COUNTRY SET  country_name = ?, country_city = ? WHERE country_id = ?";
}
