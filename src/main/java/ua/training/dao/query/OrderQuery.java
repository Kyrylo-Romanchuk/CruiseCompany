package ua.training.dao.query;

public interface OrderQuery {
    String FIND_ALL_ORDER = "SELECT * FROM CRUISE.ORDER";
    String FIND_ORDER_BY_ID = "SELECT * FROM CRUISE.ORDER WHERE ORDER_ID = ?";
    String FIND_ORDER_USER_BY_ID = "SELECT * FROM CRUISE.ORDER WHERE USER_ID = ?";
    String DELETE_ORDER_BY_ID = "DELETE FROM CRUISE.ORDER WHERE ORDER_ID = ?";
    String CREATE_ORDER = "INSERT INTO CRUISE.ORDER (user_id, cruise_id,excursion_id, price_total) VALUES(?,?,?,?)";
    String UPDATE_ORDER = "UPDATE CRUISE.ORDER SET  user_id = ?, cruise_id = ? , excursion_id=? , price_total = ? WHERE order_id = ?";
}
