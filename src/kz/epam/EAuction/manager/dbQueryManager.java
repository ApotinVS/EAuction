package kz.epam.EAuction.manager;

import java.util.ResourceBundle;

/**
 * Created by Вит on 19.10.2016.
 */
public class dbQueryManager {
    private static dbQueryManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "db_queries";
    //public static final String DO_BET = "kz.epam.EAuction.manager.dbQueryManager.do.bet";
    //public static final String GET_BET_ID = "kz.epam.EAuction.manager.dbQueryManager.get.bet.id";
    //public static final String CREATE_BIDDING = "kz.epam.EAuction.manager.dbQueryManager.create.bidding";
    //public static final String ADD_IN_BIDDING = "kz.epam.EAuction.manager.dbQueryManager.add.in.bet";
    //public static final String GET_BIDDING_ID = "kz.epam.EAuction.manager.dbQueryManager.get.bidding.id";
    //public static final String GET_BIDDING_ON_PRODUCT = "kz.epam.EAuction.manager.dbQueryManager.get.bidding.on.product";
    public  static final String CREATE_USER = "kz.epam.EAuction.manager.dbQueryManager.create.user";

    public static dbQueryManager getInstance(){
        if (instance == null){
            instance = new dbQueryManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }
    public String getProperty(String key){
        return (String)resourceBundle.getObject(key);
    }
}
