package by.it.milosh.model;

import java.util.List;

public class UserWrapper {

    private List<Long> serviceId;

    private Integer account;

    public UserWrapper() {
    }

    public List<Long> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<Long> serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }
}
