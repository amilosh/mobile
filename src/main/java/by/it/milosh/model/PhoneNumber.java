package by.it.milosh.model;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phoneNumber_id")
    private Long phoneNumber_id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "used")
    private boolean used;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PhoneNumber() {
    }

    public PhoneNumber(Integer number, boolean used) {
        this.number = number;
        this.used = used;
    }

    public Long getPhoneNumber_id() {
        return phoneNumber_id;
    }

    public void setPhoneNumber_id(Long phoneNumber_id) {
        this.phoneNumber_id = phoneNumber_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
