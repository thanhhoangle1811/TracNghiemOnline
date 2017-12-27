package demo.entities;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "accountrole", catalog = "onlinequiz")
public class AccountRole implements java.io.Serializable {

    private AccountRoleId id;
    private Account account;
    private Role role;
    private boolean enable;

    public AccountRole() {
    }

    public AccountRole(AccountRoleId id, Account account, Role role, boolean enable) {
        this.id = id;
        this.account = account;
        this.role = role;
        this.enable = enable;
    }

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(name = "accountid", column = @Column(name = "accountid", nullable = false)),
            @AttributeOverride(name = "roleid", column = @Column(name = "roleid", nullable = false)) })
    public AccountRoleId getId() {
        return this.id;
    }

    public void setId(AccountRoleId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountid", nullable = false, insertable = false, updatable = false)
    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", nullable = false, insertable = false, updatable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "enable", nullable = false)
    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}
