package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.BlackList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceBlackListDAO {
    Connection releaseConnection();
    boolean add(int userId, String description) throws SQLException;
    boolean delete(int userId) throws  SQLException;
    List<BlackList> getBlackList() throws SQLException;
    boolean hasInBlackList() throws SQLException;

}
