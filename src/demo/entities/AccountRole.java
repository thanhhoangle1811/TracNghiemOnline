package demo.entities;



import javax.persistence.*;

@Entity
@Table(name = "accountrole", catalog="onlinequiz")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.account",
                joinColumns = @JoinColumn(name = "accountid")),
        @AssociationOverride(name = "primaryKey.role",
                joinColumns = @JoinColumn(name = "roleid")) })
public class AccountRole {
    private AccountRoleId primaryKey = new AccountRoleId();
    
    private boolean enable;

    @EmbeddedId
    public AccountRoleId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(AccountRoleId primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    @Transient
    public Account getAccount() {
        return getPrimaryKey().getAccount();
    }
    public void setAccount(Account account) {
        getPrimaryKey().setAccount(account);
    }
    
    @Transient
    public Role getRole() {
        return getPrimaryKey().getRole();
    }
    public void setRole(Role role) {
        getPrimaryKey().setRole(role);
    }

    @Column(name="enable",nullable = false, length = 1)
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    
}
