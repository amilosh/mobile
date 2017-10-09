package by.it.milosh.model;

import java.util.List;

public class UserWrapper {

    private List<Long> addonId;

    private Integer balance;

    public UserWrapper() {
    }

    public List<Long> getAddonId() {
        return addonId;
    }

    public void setAddonId(List<Long> addonId) {
        this.addonId = addonId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
