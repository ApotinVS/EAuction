package kz.epam.EAuction.dao.daoFactory;

import kz.epam.EAuction.dao.daos.UserDAO;

import java.sql.SQLException;

/**
 * Created by Вит on 24.10.2016.
 */
public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public abstract UserDAO getUserDAO() throws SQLException;

    public static DAOFactory getDAOFactory (int whichFactory){
        switch (whichFactory){
            case MYSQL:
                return new MySQLDAOFactory();
            default:return null;
        }
    }

}
