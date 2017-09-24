package by.it.milosh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private Long tariff_id;

    @Column(name = "tariffName", unique = true, nullable = false)
    private String tariffName;

    @Column(name = "costPerMonth", nullable = false)
    private Integer costPerMonth;

    @Column(name = "costPerMinute", nullable = false)
    private Integer costPerMinute;

    @OneToMany(mappedBy = "tariff")
    private List<User> users;

    public Tariff() {
    }

    public Tariff(String tariffName, int costPerMonth, int costPerMinute) {
        this.tariffName = tariffName;
        this.costPerMonth = costPerMonth;
        this.costPerMinute = costPerMinute;
    }

    public Long getTariff_id() {
        return tariff_id;
    }

    public void setTariff_id(Long tariff_id) {
        this.tariff_id = tariff_id;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public Integer getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(Integer costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public Integer getCostPerMinute() {
        return costPerMinute;
    }

    public void setCostPerMinute(Integer costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
