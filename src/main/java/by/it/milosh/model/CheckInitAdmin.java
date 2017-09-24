package by.it.milosh.model;

import javax.persistence.*;

@Entity
@Table(name = "check_init_admin")
public class CheckInitAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkInitAdmin_id")
    private Long checkInitAdmin_id;

    @Column(name = "checkInit")
    private boolean checkInit;

    public CheckInitAdmin() {
    }

    public CheckInitAdmin(boolean checkInit) {
        this.checkInit = checkInit;
    }

    public Long getCheckInitAdmin_id() {
        return checkInitAdmin_id;
    }

    public void setCheckInitAdmin_id(Long checkInitAdmin_id) {
        this.checkInitAdmin_id = checkInitAdmin_id;
    }

    public boolean isCheckInit() {
        return checkInit;
    }

    public void setCheckInit(boolean checkInit) {
        this.checkInit = checkInit;
    }
}
