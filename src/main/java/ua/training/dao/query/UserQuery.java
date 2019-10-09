package ua.training.dao.query;

public interface UserQuery {

    String FIND_ALL_USER = "SELECT * FROM CRUISE.USER";
    String FIND_USER_BY_ID = "SELECT * FROM CRUISE.USER USR WHERE USER_ID = ?";
    String FIND_USER_BY_EMAIL = "SELECT * FROM CRUISE.USER WHERE USER_EMAIL = ?";
    String FIND_USER_BY_USER = "SELECT * FROM CRUISE.USER WHERE USER_LOGIN = ?";
    String DELETE_USER_BY_ID = "DELETE FROM CRUISE.USER WHERE USER_ID = ?";
    String CREATE_USER = "INSERT INTO CRUISE.USER (user_login, user_password, user_first_name,user_last_name,user_email, user_role , user_created) VALUES(?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_USER=  "UPDATE CRUISE.USER SET  user_login = ?, user_password = ? , user_first_name =?, user_last_name =?, user_email=?,user_role,user_created WHERE user_id = ?";

}
