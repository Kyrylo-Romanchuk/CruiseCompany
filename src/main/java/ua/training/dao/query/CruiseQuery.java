package ua.training.dao.query;

public interface CruiseQuery {
    String FIND_ALL_CRUISE = "SELECT * FROM CRUISE.CRUISE";
    String FIND_CRUISE_BY_ID = "SELECT * FROM CRUISE.CRUISE WHERE CRUISE_ID = ?";
    String DELETE_CRUISE_BY_ID = "DELETE FROM CRUISE.CRUISE WHERE CRUISE_ID = ?";
    String CREATE_CRUISE = "INSERT INTO CRUISE.CRUISE (cruise_name, ship_id , cruise_city_from , cruise_city_to, cruise_departure , cruise_arrival, cruise_category,cruise_count_port,cruise_price) VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_CRUISE = "UPDATE CRUISE.CRUISE SET  cruise_name = ?, ship_id = ? , cruise_city_from = ?, cruise_city_to = ?, cruise_departure = ? , cruise_arrival = ?, cruise_category = ?,cruise_count_port = ?,cruise_price = ? WHERE cruise_id = ?";
    String FIND_ALL = "select cr.cruise_id, cr.cruise_name cruise_name,sh.ship_id ship_id ," +
            "sh.ship_name ship_name,sh.ship_capacity, shim.shipimage_id, shim.shipimage_uri,c_from.country_id country_from_id, c_from.country_name " +
            "country_from_name, c_from.country_city country_from_city, c_to.country_id country_to_id ," +
            "c_to.country_name country_to_name, c_to.country_city country_to_city, cr.cruise_departure, cr.cruise_arrival," +
            "cr.cruise_category, cr.cruise_count_port, cr.cruise_price " +
            "from cruise.cruise cr " +
            "left join cruise.country c_from on cr.cruise_city_from = c_from.country_id "+
            "left join cruise.country c_to on cr.cruise_city_to = c_to.country_id "+
            "left join cruise.ship sh on cr.ship_id = sh.ship_id " +
            "left join cruise.shipimage shim on cr.ship_id= shim.ship_id";
    String FIND_ALL_WITH_LIMIT = "select cr.cruise_id, cr.cruise_name cruise_name,sh.ship_id ship_id ," +
            "sh.ship_name ship_name,sh.ship_capacity, shim.shipimage_id, shim.shipimage_uri,c_from.country_id country_from_id, c_from.country_name " +
            "country_from_name, c_from.country_city country_from_city, c_to.country_id country_to_id ," +
            "c_to.country_name country_to_name, c_to.country_city country_to_city, cr.cruise_departure, cr.cruise_arrival," +
            "cr.cruise_category, cr.cruise_count_port, cr.cruise_price " +
            "from cruise.cruise cr " +
            "left join cruise.country c_from on cr.cruise_city_from = c_from.country_id "+
            "left join cruise.country c_to on cr.cruise_city_to = c_to.country_id "+
            "left join cruise.ship sh on cr.ship_id = sh.ship_id " +
            "left join cruise.shipimage shim on cr.ship_id= shim.ship_id limit ?,?";
String COUNT_CRUISE = "select count(*) from cruise.cruise";
}
