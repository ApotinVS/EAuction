package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceRoleDAO {
    Connection releaseConnection();
    Role getRole (int id) throws SQLException;

}
