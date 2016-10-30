package kz.epam.EAuction.manager;

import java.util.ResourceBundle;

/**
 * Created by Вит on 27.10.2016.
 */
public class MessageManager {
    private static MessageManager instance;
    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "messages";

    public static final String REGISTER_ERROR_MESSAGE = "kz.epam.EAuction.model.manager.MessageManager.register.error";

    public static MessageManager getInstance(){
        if (instance == null){
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key){
        return (String) resourceBundle.getObject(key);
    }


}
