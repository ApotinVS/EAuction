package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceProductDAO {
    Connection releaseConnection();
    boolean addProduct (int categoryId, String productName, String description, int beginPrice, int fullPrice)
        throws SQLException;
    Product getProduct (String productName) throws SQLException;
    Product getProduct (int id) throws SQLException;
    List<Product> getProducts() throws  SQLException;
    List<Product> getProductsInCategory(int categoryId) throws SQLException;
}
