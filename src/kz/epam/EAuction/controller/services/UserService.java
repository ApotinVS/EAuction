package kz.epam.EAuction.controller.services;

import kz.epam.EAuction.dao.daoFactory.MySQLDAOFactory;
import kz.epam.EAuction.dao.daos.UserDAO;
import kz.epam.EAuction.model.entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 26.10.2016.
 */
public class UserService extends Service {

    public UserService() {
        super();
    }

    public UserService(String nameService) {
        super(nameService);
    }

    public UserService(int daoFactory, String nameService) {
        super(daoFactory, nameService);
    }
    //Делает апдейт всех параметров юзера, не совсем корректно по логике, в идеале надо реализовать перегруженные
    // методы для возможности апдейта юзера по отдельным данным.
    public  boolean updateUser(String login, String password, String email, String firstName, String secondName){
        UserDAO userDAO = null;
        boolean success = false;
        try{
            userDAO = (UserDAO) dao.getUserDAO();
            success = userDAO.updateUser(login, password, email, firstName,secondName);
            MySQLDAOFactory.releaseConnection(userDAO.releaseConnection());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    public User getUser(int userId){
        UserDAO userDAO = null;
        User user = null;
        try{
            userDAO = (UserDAO) dao.getUserDAO();
            user = userDAO.getUser(userId);
            MySQLDAOFactory.releaseConnection(userDAO.releaseConnection());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public User getUser (String login){
        UserDAO userDAO = null;
        User user = null;
        try {
            userDAO = (UserDAO) dao.getUserDAO();
            user = userDAO.getUser(login);
            MySQLDAOFactory.releaseConnection(userDAO.releaseConnection());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean isAdmin(String login){
        boolean isAdmin = false;
        UserDAO userDAO = null;
        User user = null;
        try{
            userDAO = (UserDAO) dao.getUserDAO();
            user = userDAO.getUser(login);
            MySQLDAOFactory.releaseConnection(userDAO.releaseConnection());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (user.getRoleId()== 1){
            isAdmin = true;
        }
        else {
            isAdmin = false;
        }
        return isAdmin;
    }

   // public List<User> getUsers(){

   // }

    @Override
    public String getNameService() {
        return super.getNameService();
    }
}
