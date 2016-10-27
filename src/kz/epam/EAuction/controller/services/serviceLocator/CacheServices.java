package kz.epam.EAuction.controller.services.serviceLocator;

import kz.epam.EAuction.controller.services.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вит on 25.10.2016.
 */
public class CacheServices {
    private List<Service> services;

    public CacheServices() {
        services = new ArrayList<Service>();
    }

    public Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getNameService().equalsIgnoreCase(serviceName)) {
               return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;
        for (Service service : services) {
            if (service.getNameService().equalsIgnoreCase(
                    newService.getNameService())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}
