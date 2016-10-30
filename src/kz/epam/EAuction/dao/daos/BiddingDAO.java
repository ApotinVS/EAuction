package kz.epam.EAuction.dao.daos;

import kz.epam.EAuction.dao.daoInterfaces.InterfaceBiddingDAO;
import kz.epam.EAuction.manager.dbQueryManager;
import kz.epam.EAuction.model.entities.Bidding;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Вит on 19.10.2016.
 */
/*public class BiddingDAO implements InterfaceBiddingDAO {
    Connection connection;
    public BiddingDAO(){
        this.connection = null;
    }
    public BiddingDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Connection releaseConnection() {
        return this.connection;
    }

    @Override
    public int createBidding(int productId, java.util.Date dateDead) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean success = false;
        java.util.Date dateBegining = new java.util.Date();
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.CREATE_BIDDING));
            preparedStatement.setInt(1,productId);
            preparedStatement.setDate(2, new Date(dateBegining.getTime()));
            preparedStatement.setDate(3, new Date(dateDead.getTime()));
            preparedStatement.execute();
            success = true;
            connection.commit();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }

        ResultSet resultSet= null;
        int biddingId = -1;
        try {
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.GET_BIDDING_ID));
            preparedStatement.setInt(1,productId);
            preparedStatement.setDate(2, new Date(dateBegining.getTime()));
            preparedStatement.setDate(3, new Date(dateDead.getTime()));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                biddingId = resultSet.getInt(1);
            }
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if ( resultSet != null){
                resultSet.close();
            }
        }
        return biddingId;
    }

    @Override
    public int addInBidding(int betId, int productId) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean success = false;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.ADD_IN_BIDDING));
            preparedStatement.setInt(1,betId);
            preparedStatement.setInt(2,productId);

            preparedStatement.execute();
            success = true;
            connection.commit();
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }

        ResultSet resultSet= null;
        int biddingId = -1;
        try {
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.GET_BIDDING_ID));
            preparedStatement.setInt(1,betId);
            preparedStatement.setInt(2,productId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                biddingId = resultSet.getInt(1);
            }
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if ( resultSet != null){
                resultSet.close();
            }
        }
        return biddingId;
    }

    @Override
    public Bidding getBiddingOnProduct(int productId) throws SQLException {
        PreparedStatement preparedStatement = null;
        Bidding bidding = null;
        boolean success = false;
        try {
            preparedStatement = connection.prepareStatement(dbQueryManager.getInstance().
                    getProperty(dbQueryManager.GET_BIDDING_ON_PRODUCT));
            preparedStatement.setInt(1,productId);
            ResultSet resultSet = null;
            try {
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    bidding = new Bidding(resultSet.getInt(1), resultSet.getInt(2),resultSet.getDate(3));
                }
            }
            finally {
                if (resultSet != null){
                    resultSet.close();
                }
            }
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
        return bidding;
    }

    @Override
    public List<Bidding> getBiddings() throws SQLException {
        return null;
    }
}*/
