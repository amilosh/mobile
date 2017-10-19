package by.it.milosh.model;

import java.util.List;

public class UserWrapper {

    private List<Long> addonIds;

    private Integer balance;

    public UserWrapper() {
    }

    public List<Long> getAddonIds() {
        return addonIds;
    }

    public void setAddonIds(List<Long> addonIds) {
        this.addonIds = addonIds;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
