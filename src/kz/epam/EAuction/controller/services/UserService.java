package kz.epam.EAuction.controller.services;

/**
 * Created by Вит on 26.10.2016.
 */
public class UserService extends Service {
    public UserService() {
        super();
    }

    public UserService(String nameService) {
        super(nameService);
    }

    public UserService(int daoFactory, String nameService) {
        super(daoFactory, nameService);
    }

    @Override
    public String getNameService() {
        return super.getNameService();
    }
}
