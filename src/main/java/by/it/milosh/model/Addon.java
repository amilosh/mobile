package by.it.milosh.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addon")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addonId")
    private Long addonId;

    @Column(name = "service_name", unique = true, nullable = false)
    private String addonName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "connect_cost", nullable = false)
    private Integer connectCost;

    @Column(name = "cost_per_month", nullable = false)
    private Integer costPerMonth;

    @ManyToMany(mappedBy = "addons"
            //, fetch = FetchType.EAGER, cascade = {CascadeType.ALL}
    )
    private List<User> users = new ArrayList<User>();

    public Addon() {
    }

    public Addon(String addonName, String description, Integer connectCost, Integer costPerMonth) {
        this.addonName = addonName;
        this.description = description;
        this.connectCost = connectCost;
        this.costPerMonth = costPerMonth;
    }

    public Long getAddonId() {
        return addonId;
    }

    public void setAddonId(Long addonId) {
        this.addonId = addonId;
    }

    public String getAddonName() {
        return addonName;
    }

    public void setAddonName(String addonName) {
        this.addonName = addonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getConnectCost() {
        return connectCost;
    }

    public void setConnectCost(Integer connectCost) {
        this.connectCost = connectCost;
    }

    public Integer getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(Integer costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
