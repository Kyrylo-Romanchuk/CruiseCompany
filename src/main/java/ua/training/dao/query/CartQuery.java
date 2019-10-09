package ua.training.dao.query;

public interface CartQuery {
    String FIND_ALL_CART = "SELECT * FROM CRUISE.CART";
    String FIND_CART_BY_ID = "SELECT * FROM CRUISE.CART WHERE CART_ID = ?";
    String FIND_CART_USER_BY_ID = "SELECT * FROM CRUISE.CART WHERE USER_ID = ?";
    String DELETE_CART_BY_ID = "DELETE FROM CRUISE.CART WHERE CART_ID = ?";
    String CREATE_CART = "INSERT INTO CRUISE.CART (user_id, cruise_id) VALUES(?,?)";
    String UPDATE_CART = "UPDATE CRUISE.CART SET  user_id = ?, cruise_id = ?  WHERE cart_id = ?";

}
