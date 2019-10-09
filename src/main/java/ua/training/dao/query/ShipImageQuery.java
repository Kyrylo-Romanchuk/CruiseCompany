package ua.training.dao.query;

public interface ShipImageQuery {
    String FIND_ALL_SHIP_IMAGE = "SELECT * FROM CRUISE.SHIPIMAGE";
    String FIND_SHIP_IMAGE_BY_ID = "SELECT * FROM CRUISE.SHIPIMAGE WHERE SHIP_ID = ?";
    String DELETE_SHIP_IMAGE_BY_ID = "DELETE FROM CRUISE.SHIPIMAGE WHERE SHIP_ID = ?";
    String CREATE_SHIP_IMAGE = "INSERT INTO CRUISE.SHIPIMAGE (shipimage_uri) VALUES(?)";
    String UPDATE_SHIP_IMAGE=  "UPDATE CRUISE.SHIPIMAGE SET  shipimage_uri = ? WHERE shipimage_id = ?";

}