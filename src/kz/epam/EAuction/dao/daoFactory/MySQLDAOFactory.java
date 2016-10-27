package kz.epam.EAuction.dao.daoFactory;

import kz.epam.EAuction.dao.daos.UserDAO;
import kz.epam.EAuction.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Вит on 24.10.2016.
 */
public class MySQLDAOFactory extends DAOFactory {

    private static ConnectionPool pool;
    public MySQLDAOFactory(){
        MySQLDAOFactory.pool = null;
    }
    public void setConnectionPool(ConnectionPool pool){
        MySQLDAOFactory.pool=pool;
    }
    public static synchronized void releaseConnection(Connection connection){
        pool.release(connection);
    }

    @Override
    public UserDAO getUserDAO() throws SQLException {
        Connection connection = createConnection();
        if (connection == null){

        }
        return new UserDAO(connection);
    }

    public static synchronized Connection createConnection() {
        Connection connection = null;
        connection = pool.takeConnection();
        return connection;
    }
}
