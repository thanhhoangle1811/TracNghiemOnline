package demo.entities;

import java.util.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "account", catalog = "onlinequiz")
public class Account implements java.io.Serializable {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean enabled;
    private List<AccountExam> accountexams = new ArrayList<AccountExam>(0);
    private List<AccountRole> accountroles = new ArrayList<AccountRole>(0);

    public Account() {
    }

    public Account(String firstname, String lastname, String email, String password, boolean enabled) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public Account(String firstname, String lastname, String email, String password, boolean enabled,
            List<AccountExam> accountexams, List<AccountRole> accountroles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.accountexams = accountexams;
        this.accountroles = accountroles;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 300)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    public List<AccountExam> getAccountexams() {
        return this.accountexams;
    }

    public void setAccountexams(List<AccountExam> accountexams) {
        this.accountexams = accountexams;
    }

    @OneToMany(mappedBy = "primaryKey.account", cascade = CascadeType.ALL)
    public List<AccountRole> getAccountroles() {
        return this.accountroles;
    }

    public void setAccountroles(List<AccountRole> accountroles) {
        this.accountroles = accountroles;
    }
    public void addAccountRoles(AccountRole accountRole) {
        this.accountroles.add(accountRole);
    }  

}
