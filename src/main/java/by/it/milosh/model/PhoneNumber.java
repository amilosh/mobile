package by.it.milosh.model;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phoneNumberId")
    private Long phoneNumberId;

    @Column(name = "number", unique = true, nullable = false)
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

    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
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
