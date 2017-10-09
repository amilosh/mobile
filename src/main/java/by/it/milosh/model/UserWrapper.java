package by.it.milosh.model;

import java.util.List;

public class UserWrapper {

    private List<Long> addonId;

    private Integer account;

    public UserWrapper() {
    }

    public List<Long> getAddonId() {
        return addonId;
    }

    public void setAddonId(List<Long> addonId) {
        this.addonId = addonId;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }
}
