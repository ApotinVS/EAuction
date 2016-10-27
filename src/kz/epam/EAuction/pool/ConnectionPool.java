package kz.epam.EAuction.pool;

import kz.epam.EAuction.manager.ConfigurationManager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Вит on 24.10.2016.
 */
public class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionsQueue;
    private static String driver;
    private static String url;
    private static String userName;
    private static String password;
    private static int poolSize;

    private ConnectionPool(String driver, String url, String userName,String password, int poolSize){
        loadDriver();
        connectionsQueue = new ArrayBlockingQueue<Connection>(poolSize);
        for (int i = 0; i <poolSize ; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url,userName,password);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            connectionsQueue.offer(connection);
        }
    }

    private void loadDriver() {
        Driver dr = null;
        try {
            dr = (Driver) Class.forName(ConfigurationManager.getInstance().getProperty(
                    ConfigurationManager.DATABASE_DRIVER_NAME)).newInstance();
            try {
                DriverManager.registerDriver(dr);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (InstantiationException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection takeConnection(){
        Connection connection = null;
        try {
            connection = connectionsQueue.take();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return connection;
    }
    public void release(Connection connection){
        try {
            if (!connection.isClosed()){
                connectionsQueue.offer(connection);
            } else {
                connectionsQueue.remove(connection);
                connection = DriverManager.getConnection(url, userName, password);
                connectionsQueue.offer(connection);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static synchronized ConnectionPool getInstance(){
        if(instance == null){
            ConfigurationManager conf = ConfigurationManager.getInstance();
            ConnectionPool.driver = conf.getProperty(ConfigurationManager.DATABASE_DRIVER_NAME);
            ConnectionPool.url = conf.getProperty(ConfigurationManager.DATABASE_URL);
            ConnectionPool.userName = conf.getProperty(ConfigurationManager.DATABASE_USER);
            ConnectionPool.password = conf.getProperty(ConfigurationManager.DATABASE_PASSWORD);
            ConnectionPool.poolSize = Integer.parseInt(conf.getProperty(ConfigurationManager.CONNECTION_POOL_SIZE));
            instance = new ConnectionPool(driver, url, userName, password, poolSize);
        }
        return instance;
    }

}
