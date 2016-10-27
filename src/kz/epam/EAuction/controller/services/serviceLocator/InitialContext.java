package kz.epam.EAuction.controller.services.serviceLocator;

import kz.epam.EAuction.controller.services.Service;
import kz.epam.EAuction.controller.services.SignupServices;

/**
 * Created by Вит on 25.10.2016.
 */
public class InitialContext {
    public Service lookup(String serviceName, int daoFactory) {
        switch (serviceName) {

            case "singup":
                return (Service) new SignupServices(daoFactory, serviceName);

            default:
                return null;
        }
    }
}
