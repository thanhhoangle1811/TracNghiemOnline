package demo.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AccountRoleId implements java.io.Serializable {

    private int accountid;
    private int roleid;

    public AccountRoleId() {
    }

    public AccountRoleId(int accountid, int roleid) {
        this.accountid = accountid;
        this.roleid = roleid;
    }

    @Column(name = "accountid", nullable = false)
    public int getAccountid() {
        return this.accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    @Column(name = "roleid", nullable = false)
    public int getRoleid() {
        return this.roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof AccountRoleId))
            return false;
        AccountRoleId castOther = (AccountRoleId) other;

        return (this.getAccountid() == castOther.getAccountid()) && (this.getRoleid() == castOther.getRoleid());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getAccountid();
        result = 37 * result + this.getRoleid();
        return result;
    }

}
