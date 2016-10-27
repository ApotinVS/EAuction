package kz.epam.EAuction.controller.services.serviceLocator;

import kz.epam.EAuction.controller.services.Service;
import kz.epam.EAuction.dao.daoFactory.DAOFactory;

/**
 * Created by Вит on 25.10.2016.
 */
public class ServiceLocator {
    private static CacheServices cache;

    static {
        cache = new CacheServices();
    }

    public static Service getService(String serviceName) {
        Service service = cache.getService(serviceName);
        if (service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        Service newService = (Service) context.lookup(serviceName,
                DAOFactory.MYSQL);
        cache.addService(newService);
        return newService;
    }
}
