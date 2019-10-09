package ua.training.dao.connection;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnection {
    private static final Logger logger = Logger.getLogger(DataSourceConnection.class.getName());
    private static final String JNDI_LOOKUP_SERVICE= "java:comp/env/jdbc/cruise";
    public static Connection getConnection() {
        Connection connection = null;
        DataSource ds;
        try {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup(JNDI_LOOKUP_SERVICE);
            connection = ds.getConnection();
            connection.setAutoCommit(false);
        } catch (NamingException e) {
            logger.error( e.getMessage());
        } catch (SQLException e) {
            logger.error( e.getMessage());
        }
        return connection;
    }
}
