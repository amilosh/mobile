package by.it.milosh.model;

import java.util.List;

public class UserWrapper {

    private List<Long> serviceId;

    public UserWrapper() {
    }

    public List<Long> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<Long> serviceId) {
        this.serviceId = serviceId;
    }
}
