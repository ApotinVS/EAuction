package kz.epam.EAuction.manager;

import java.util.ResourceBundle;

/**
 * Created by Вит on 24.10.2016.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "config";

    public static final String DATABASE_DRIVER_NAME = "kz.epam.EAuction.manager.ConfigurationManager.jdbc.driver";
    public static final String DATABASE_URL = "kz.epam.EAuction.manager.ConfigurationManager.db.url";
    public static final String DATABASE_USER = "kz.epam.EAuction.manager.ConfigurationManager.db.user";
    public static final String DATABASE_PASSWORD = "kz.epam.EAuction.manager.ConfigurationManager.db.password";
    public static final String CONNECTION_POOL_SIZE = "kz.epam.EAuction.manager.ConfigurationManager.connection.pool.size";


    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String)resourceBundle.getObject(key);
    }
}
