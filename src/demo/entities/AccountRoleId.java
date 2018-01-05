package demo.entities;

import java.io.Serializable;
import demo.entities.*;
import javax.persistence.*;

@Embeddable
public class AccountRoleId implements Serializable{
    private Account account;
    private Role role;
    
    @ManyToOne(cascade = CascadeType.ALL)
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    

}
