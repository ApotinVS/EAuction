package kz.epam.EAuction.dao.daos;

import kz.epam.EAuction.dao.daoInterfaces.InterfaceBetDAO;
import kz.epam.EAuction.manager.dbQueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Вит on 19.10.2016.
 */
public class BetDAO implements InterfaceBetDAO {
    private Connection connection;
    public BetDAO(){
        this.connection = null;
    }
    public BetDAO (Connection connection){
        this.connection = connection;
    }

    @Override
    public Connection releaseConnection() {
        return this.connection;
    }

    @Override
    public int doBet(int userId, int statusId, int rating) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean success = false;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.DO_BET));
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, statusId);
            preparedStatement.setInt(3, rating);
            preparedStatement.execute();
            success = true;
            connection.commit();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }

        }
        ResultSet resultSet = null;
        int betId = -1;
        try {
            preparedStatement = connection.prepareStatement(dbQueryManager.
                    getInstance().getProperty(dbQueryManager.GET_BET_ID));
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,statusId);
            preparedStatement.setInt(3,rating);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                betId = resultSet.getInt(1);
            }
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }
        return betId;
    }
}
