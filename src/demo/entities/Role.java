package demo.entities;


import java.util.*;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role", catalog = "onlinequiz")
public class Role implements java.io.Serializable {

    private Integer id;
    private String name;
    private List<AccountRole> accountroles = new ArrayList<AccountRole>(0);

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, List<AccountRole> accountroles) {
        this.name = name;
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

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public List<AccountRole> getAccountroles() {
        return this.accountroles;
    }

    public void setAccountroles(List<AccountRole> accountroles) {
        this.accountroles = accountroles;
    }

}
