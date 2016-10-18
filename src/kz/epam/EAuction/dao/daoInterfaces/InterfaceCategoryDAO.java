package kz.epam.EAuction.dao.daoInterfaces;

import kz.epam.EAuction.model.entities.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вит on 19.10.2016.
 */
public interface InterfaceCategoryDAO {
    Connection releaseConnection();
    Category getCategory(String category) throws SQLException;
    Category getCategory (int id) throws SQLException;
    List<Category> getCategories () throws SQLException;

}
