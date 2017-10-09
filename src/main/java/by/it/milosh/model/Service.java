package by.it.milosh.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serviceId")
    private Long serviceId;

    @Column(name = "service_name", unique = true, nullable = false)
    private String serviceName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "connect_cost", nullable = false)
    private Integer connectCost;

    @Column(name = "cost_per_month", nullable = false)
    private Integer costPerMonth;

    @ManyToMany(mappedBy = "services")
    private List<User> users = new ArrayList<User>();

    public Service() {
    }

    public Service(String serviceName, String description, Integer connectCost, Integer costPerMonth) {
        this.serviceName = serviceName;
        this.description = description;
        this.connectCost = connectCost;
        this.costPerMonth = costPerMonth;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
