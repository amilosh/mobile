package by.it.milosh.model;

import javax.persistence.*;

@Entity
@Table(name = "check_init_admin")
public class CheckInitAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkInitAdminId")
    private Long checkInitAdminId;

    @Column(name = "checkInit")
    private boolean checkInit;

    public CheckInitAdmin() {
    }

    public CheckInitAdmin(boolean checkInit) {
        this.checkInit = checkInit;
    }

    public Long getCheckInitAdminId() {
        return checkInitAdminId;
    }

    public void setCheckInitAdminId(Long checkInitAdminId) {
        this.checkInitAdminId = checkInitAdminId;
    }

    public boolean isCheckInit() {
        return checkInit;
    }

    public void setCheckInit(boolean checkInit) {
        this.checkInit = checkInit;
    }
}
