package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.Bidding;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceBiddingDAO {
    Connection releaseConnection();
    boolean addInBidding(int betId,int productId) throws SQLException;
    Bidding getBiddingOnProduct (int productId) throws SQLException;
    List<Bidding> getBiddings () throws SQLException;
}
