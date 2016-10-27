package kz.epam.EAuction.controller.services;

import kz.epam.EAuction.dao.daoFactory.DAOFactory;
import kz.epam.EAuction.dao.daoFactory.MySQLDAOFactory;
import kz.epam.EAuction.pool.ConnectionPool;

/**
 * Created by Вит on 24.10.2016.
 */
public abstract class Service {
    private String nameService;
    private ConnectionPool connectionPool;
    protected DAOFactory dao;
    public Service(){

    }
    public Service (String nameService){
        this.nameService = nameService;
    }
    public Service(int daoFactory, String nameService){
        connectionPool = ConnectionPool.getInstance();
        dao = DAOFactory.getDAOFactory(daoFactory);
        if (dao instanceof MySQLDAOFactory){
            MySQLDAOFactory mySQLDAOFactory = (MySQLDAOFactory) dao;
            mySQLDAOFactory.setConnectionPool(connectionPool);
        }
        this.nameService = nameService;
    }
    public String getNameService(){
        return nameService;
    }


}
