package kz.epam.EAuction.dao.daos;

import kz.epam.EAuction.dao.daoInterfaces.InterfaceUserDAO;
import kz.epam.EAuction.manager.dbQueryManager;
import kz.epam.EAuction.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 24.10.2016.
 */
public class UserDAO implements InterfaceUserDAO {
    private Connection connection;

    public UserDAO(){
        this.connection = null;
    }
    public UserDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Connection releaseConnection() {
        return this.connection;
    }

    @Override
    public boolean createUser(int roleId, /*int repositoryId,*/ String login,
                              String password, String email, String firstName, String secondName) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean success = false;
        try {
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().getProperty(
                    dbQueryManager.CREATE_USER));
            preparedStatement.setInt(1,roleId);
            //preparedStatement.setInt(2,repositoryId);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, firstName);
            preparedStatement.setString(7, secondName);
            preparedStatement.execute();
            success = true;
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
        return success;
    }

    @Override
    public boolean updateUser(/*int repositoryId,*/ String login, String password, String email, String firstName, String secondName) throws SQLException {
        return false;
    }

    @Override
    public User getUser(String login) throws SQLException {
        return null;
    }

    @Override
    public User getUser(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        return null;
    }

    @Override
    public boolean hasUser(String login) throws SQLException {
        return false;
    }
}
