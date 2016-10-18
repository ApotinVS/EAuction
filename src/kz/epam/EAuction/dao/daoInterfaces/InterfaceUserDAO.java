package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceUserDAO {
    public Connection releaseConnection();
    boolean createUser(int roleId, int repositoryId, String login, String password,
                       String email, String firstName, String secondName) throws SQLException;
    boolean updateUser(int repositoryId, String login, String password,
                       String email, String firstName, String secondName) throws SQLException;
    User getUser (String login) throws SQLException;
    User getUser (int id) throws SQLException;
    List <User> getUsers() throws SQLException;
    boolean hasUser (String login) throws SQLException;

}
