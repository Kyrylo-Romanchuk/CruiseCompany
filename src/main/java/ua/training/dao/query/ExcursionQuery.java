package ua.training.dao.query;

public interface ExcursionQuery {
    String FIND_ALL_EXCURSION = "SELECT * FROM CRUISE.EXCURSION";
    String FIND_EXCURSION_BY_ID = "SELECT * FROM CRUISE.EXCURSION left join CRUISE.EXCURSIONIMAGE using(excursion_id) WHERE EXCURSION_ID = ?";
    String FIND_EXCURSION_COUNTRY_BY_ID = "SELECT * FROM CRUISE.EXCURSION left join CRUISE.EXCURSIONIMAGE using(excursion_id) WHERE COUNTRY_ID = ?";
    String DELETE_EXCURSION_BY_ID = "DELETE FROM CRUISE.EXCURSION WHERE EXCURSION_ID = ?";
    String CREATE_EXCURSION = "INSERT INTO CRUISE.EXCURSION (country_id, excursion_name , excursion_description , excursion_price) VALUES(?, ?, ?, ?)";
    String UPDATE_EXCURSION=  "UPDATE CRUISE.EXCURSION SET  country_id = ?, excursion_name = ? , excursion_description = ?, excursion_price = ? WHERE excursion_id = ?";
    String FIND_ALL_WITH_EXCURSION_IMAGE= "select * from CRUISE.EXCURSION left join CRUISE.EXCURSIONIMAGE using(excursion_id)";


}
