package kz.epam.EAuction.dao.daoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceBetDAO {
    Connection releaseConnection();
    int doBet(int userId, int statusId, int rating) throws SQLException;



}
