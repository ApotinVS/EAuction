package kz.epam.EAuction.controller.services;

import kz.epam.EAuction.dao.daoFactory.MySQLDAOFactory;
import kz.epam.EAuction.dao.daos.UserDAO;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Вит on 24.10.2016.
 */
public class SignupServices extends Service {
    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String EMAIL = "email";
    private final String LOGIN_PATTERN = "[_A-Za-z0-9]{3,}";
    private final String PASSWORD_PATTERN = "[A-Za-z0-9]{3,}";
    private final String EMAIL_PATTERN = "[_A-Za-z]+(\\.[_A-Za-z0-9]+)*@"
            + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
    private final int ROLE_ID_DEFAULT = 2;

    public SignupServices() {
        super();
    }
    public SignupServices(int daoFactory, String nameService){
        super(daoFactory,nameService);
    }

    public SignupServices(String nameService) {
        super(nameService);
    }

    @Override
    public String getNameService() {
        return super.getNameService();
    }
    public boolean Valid(String param, String type){
        Pattern p = null;
        Matcher m = null;
        switch (type){
            case LOGIN:
                p = Pattern.compile(LOGIN_PATTERN);
                m = p.matcher(param);
                return m.matches();
            case PASSWORD:
                p = Pattern.compile(PASSWORD_PATTERN);
                m = p.matcher(param);
                return m.matches();

            case EMAIL:
                p = Pattern.compile(EMAIL_PATTERN);
                m = p.matcher(param);
                return m.matches();

            default:
                return false;
        }
    }
    public boolean createUser(String login, String password, String email, String firstName, String secondName){
        UserDAO userDAO = null;
        boolean success = false;
        try {
            userDAO = dao.getUserDAO();
            success = userDAO.createUser(ROLE_ID_DEFAULT,login, password, email, firstName, secondName);
            MySQLDAOFactory.releaseConnection(userDAO.releaseConnection());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }

}

