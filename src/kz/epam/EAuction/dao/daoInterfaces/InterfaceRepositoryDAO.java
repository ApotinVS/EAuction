package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceRepositoryDAO {
    Connection releaseConnection();
    Repository getRepository (int id) throws SQLException;
}
